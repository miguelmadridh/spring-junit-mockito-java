package com.unittesting.inittesting.bussines;

import static org.junit.Assert.*;

import org.junit.Test;

public class BussinesImplTest {

  @Test
  public void  calculateSum_basicTest(){
    BussinesImpl bussines = new BussinesImpl();
    int actualValue = bussines.calculateSum(new int[]{1,2,3,4});
    int expectedValue = 10;
    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void  calculateSum_emptyValueTest(){
    BussinesImpl bussines = new BussinesImpl();
    int actualValue = bussines.calculateSum(new int[]{});
    int expectedValue = 0;
    assertEquals(expectedValue,actualValue);
  }

  @Test
  public void  calculateSum_oneValueTest(){
    BussinesImpl bussines = new BussinesImpl();
    int actualValue = bussines.calculateSum(new int[]{1});
    int expectedValue = 1;
    assertEquals(expectedValue,actualValue);
  }
}