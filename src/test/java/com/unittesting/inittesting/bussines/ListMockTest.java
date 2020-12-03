package com.unittesting.inittesting.bussines;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

  List<String> mock = mock(List.class);

  @Test
  public void list_basic() {
    when(mock.size()).thenReturn(5);
    Assert.assertEquals(5, mock.size());

  }

  @Test
  public void two_Values() {
    when(mock.size()).thenReturn(5).thenReturn(10);
    Assert.assertEquals(5, mock.size());
    Assert.assertEquals(10, mock.size());
  }

  @Test
  public void params_Values() {
    when(mock.get(0)).thenReturn("Hola");
    Assert.assertEquals("Hola", mock.get(0));
    Assert.assertEquals(null, mock.get(1));
  }

  @Test
  public void genericParams_Values() {
    when(mock.get(anyInt())).thenReturn("Hola");
    Assert.assertEquals("Hola", mock.get(0));
    Assert.assertEquals("Hola", mock.get(1));
  }

  @Test
  public void verifiy_TestCases() {
    String value = mock.get(0);
    String value1 = mock.get(1);
    verify(mock).get(1);
    verify(mock, never()).get(2);
    verify(mock, times(2)).get(anyInt());
    verify(mock, atLeast(1)).get(anyInt());
    verify(mock, atMost(2)).get(anyInt());
    verify(mock, atLeastOnce()).get(anyInt());

  }

  @Test
  public void argumentCapturing_test() {
    mock.add("SomeString");
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
    verify(mock).add(stringArgumentCaptor.capture());
    Assert.assertEquals("SomeString", stringArgumentCaptor.getValue());

  }


  @Test
  public void multipleArgumentCapturing_test() {
    mock.add("SomeString");
    mock.add("SomeString2");
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
    verify(mock, times(2)).add(stringArgumentCaptor.capture());
    List<String> allValues = stringArgumentCaptor.getAllValues();
    Assert.assertEquals("SomeString", allValues.get(0));
    Assert.assertEquals("SomeString2", allValues.get(1));

  }

  @Test
  public void mocking() {
    /***
     * aqui mockeamos todo, el funcionamiento ya no es el original por que todo es un mock
     *
     */
    ArrayList<String> stringArrayList = mock(ArrayList.class);
    /**
     *  Por eso aunque aqui deberia de arrojar una excepcion por que estaa hacienddo un null pointer
     * no hace nada.
     */
    System.out.println(stringArrayList.get(0));
    stringArrayList.add("Texto1");
    stringArrayList.add("Texto2");
    /***
     * y aqui aunque lle agregamos va a mandar cero por que como todo el funcionamiento esta mockeado.
     *
     */
    System.out.println(stringArrayList.size());
     /**
      aqui sobreescribimos el metodo y es por eso que ahora va a arrojar 5 por que ccon el then lo sobreescribimos
    */
     when(stringArrayList.size()).thenReturn(5);
    System.out.println(stringArrayList.size());
  }


  @Test
  public void spying() {
    /***
     * aqui ya replica todo, el funcionamiento ya  es el original
     *
     */
    ArrayList<String> stringArrayList = spy(ArrayList.class);
    /**
     *  Por eso  aqui deberia de arrojar una excepcion por que estaa hacienddo un null pointer
     * .
     */
    stringArrayList.add("Texto");
    System.out.println(stringArrayList.get(0));
    stringArrayList.add("Texto1");
    stringArrayList.add("Texto2");
    /***
     * y aqui  lle agregamos va a mandar 3 por que como todo el funcionamiento .
     *
     */
    System.out.println(stringArrayList.size());
    /**
     aqui sobreescribimos el metodo y es por eso que ahora va a arrojar 5 por que ccon el then lo sobreescribimos
     */
    when(stringArrayList.size()).thenReturn(5);
    System.out.println(stringArrayList.size());
  }
}
