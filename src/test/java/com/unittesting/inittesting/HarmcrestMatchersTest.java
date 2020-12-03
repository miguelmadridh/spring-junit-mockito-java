package com.unittesting.inittesting;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HarmcrestMatchersTest {

  @Test
  public void learning() {
    List<Integer> integers = Arrays.asList(11, 12, 13, 14, 15);

    assertThat(integers, hasSize(5));
    assertThat(integers, hasItems(13, 14));
    assertThat(integers, everyItem(greaterThan(10)));
    assertThat(integers, everyItem(lessThan(100)));

    assertThat("", isEmptyString());
    assertThat("ABCDE", containsString("BCD"));
    assertThat("ABCDE", startsWith("ABC"));
    assertThat("ABCDE", endsWith("CDE"));

  }
}
