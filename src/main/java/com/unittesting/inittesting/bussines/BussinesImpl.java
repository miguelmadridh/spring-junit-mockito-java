package com.unittesting.inittesting.bussines;

import com.unittesting.inittesting.service.SomeDataService;
import java.util.Arrays;

public class BussinesImpl {

  private SomeDataService someDataService;

  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }


  public int calculateSum(int[] values) {
    return Arrays.stream(values).reduce(Integer::sum).orElse(0);
  }

  public int calculateSumUsingDataService() {
    return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
  }
}
