package com.unittesting.inittesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class AssertJTest {


  @Test
  public void learning() {
    List<Integer> numbers = Arrays.asList(12, 15, 45);
    assertThat(numbers).hasSize(3)
        .contains(12, 15)
        .allMatch(x -> x > 10)
        .allMatch(x -> x < 100)
        .noneMatch(x -> x < 0);

    String testString = "ABCE";

    assertThat("").isEmpty();
    assertThat(testString)
        .contains("AB")
        .endsWith("CE")
        .startsWith("AB");
  }

}
