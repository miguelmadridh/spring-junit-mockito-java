package com.unittesting.inittesting.controller;


import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTests {

  private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

  @Test
  public void jsonAssert_StrinctTrue() throws JSONException {
    String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    /**
     * Cuando tiene el struct en true deben dde ser iguales los objetos ,
     * puede tener espacios en
     * blanco ambas cadenas pero las estrucuturas deben de ser iguales
     */
    JSONAssert.assertEquals(expectedResponse, actualResponse, true);
  }


  @Test
  public void jsonAssert_StrictFalse() throws JSONException {
    String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
    /**
     * Cuando tiene el struct en false deben pueden ser diferentes los objetos ,
     * puede tener espacios en
     * blanco ambas cadenas pero las estrucuturas deben de ser iguales
     */
    JSONAssert.assertEquals(expectedResponse, actualResponse, false);

  }


  @Test
  public void jsonAssert_WithOutScape() throws JSONException {
    String expectedResponse = "{id:1,name:Ball,price:10}";
    JSONAssert.assertEquals(expectedResponse, actualResponse, false);
  }
}
