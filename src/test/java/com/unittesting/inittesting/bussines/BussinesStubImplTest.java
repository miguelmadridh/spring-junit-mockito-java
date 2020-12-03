package com.unittesting.inittesting.bussines;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BussinesStubImplTest {

  @Test
  public void calculateSum_basicTest() {
    BussinesImpl bussines = new BussinesImpl();
    bussines.setSomeDataService(() -> new int[]{1, 2, 3, 4, 5, 6});
    int expectedValue = 21;
    int actualValue = bussines.calculateSumUsingDataService();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void calculateSum_emptyValueTest() {
    BussinesImpl bussines = new BussinesImpl();
    bussines.setSomeDataService(() -> new int[]{});
    int actualValue = bussines.calculateSumUsingDataService();
    int expectedValue = 0;
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void calculateSum_oneValueTest() {
    BussinesImpl bussines = new BussinesImpl();
    bussines.setSomeDataService(() -> new int[]{1});
    int actualValue = bussines.calculateSumUsingDataService();
    int expectedValue = 1;
    assertEquals(expectedValue, actualValue);
  }
}