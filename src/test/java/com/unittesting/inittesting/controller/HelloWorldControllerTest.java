package com.unittesting.inittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
// con este le decimos que aqui estan los controladores
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void helloWorld() throws Exception {
    //Hacemos el request /hello
    RequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
        .get("/hello").accept(MediaType.APPLICATION_JSON); // esto es para decirle del JSON
    MvcResult perform = mockMvc.perform(mockHttpServletRequestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().string("Hello-world"))
        .andReturn(); // ejecutamos ell reuqest
    //assertEquals("Hello-world", perform.getResponse().getContentAsString());
  }
}