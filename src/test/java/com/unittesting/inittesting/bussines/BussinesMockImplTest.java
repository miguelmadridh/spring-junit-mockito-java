package com.unittesting.inittesting.bussines;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.unittesting.inittesting.service.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BussinesMockImplTest {
  //Esta clase esta esperando una dependencia de otra clase
  //por eso es a laa que le ponemos inject mock, vamos a inyectarle un mock
  @InjectMocks
  BussinesImpl bussines;
  /*
  Esta es la clases que vamos a mockear y con esta anotacion ya no es necesario
  el set
   */
  @Mock
  SomeDataService someDataServiceMock;

  @Test
  public void calculateSum_basicTest() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
    assertEquals(21, bussines.calculateSumUsingDataService());
  }

  @Test
  public void calculateSum_emptyValueTest() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
    assertEquals(0, bussines.calculateSumUsingDataService());
  }

  @Test
  public void calculateSum_oneValueTest() {
    when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1});
    assertEquals(1, bussines.calculateSumUsingDataService());

  }
}