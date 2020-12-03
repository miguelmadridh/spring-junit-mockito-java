package com.unittesting.inittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerITTest {

  @Autowired
  TestRestTemplate testRestTemplate;


  /*
    @MockBean
    ItemRepository itemRepository;
   */


  @Test
  public void contextLoads() throws JSONException {
    String response = testRestTemplate.getForObject("/item-from-database", String.class);
    JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
  }

}