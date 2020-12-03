package com.unittesting.inittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.unittesting.inittesting.bussines.ItemBussinessService;
import com.unittesting.inittesting.model.Item;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  MockMvc mockMvc;
  @MockBean
  ItemBussinessService itemBussinessService;


  @Test
  public void dummyItem() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
        .andExpect(content().json(
            "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
        .andReturn();

  }

  @Test
  public void itemFromBussinesService_test() throws Exception {
    when(itemBussinessService.retrieveHardCodedItem()).thenReturn(new Item(1, "Ball", 10, 100));
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
        .andExpect(content().json(
            "{id:1,name:Ball,price:10,quantity:100}"))
        .andReturn();

  }


  @Test
  public void itemFromDatabase_test() throws Exception {

    when(itemBussinessService.retrieveAllItems()).thenReturn(Arrays.asList(
        new Item(1, "Item1", 10, 10),
        new Item(2, "Item2", 20, 30)
    ));
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-database")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        // Este treuna por que espera dos y obtiene uno .andExpect(content().json("[{id:1,name:Item1,price:10,quantity:10}]"))
        // Este truena por que los valores son diferentes .andExpect(content().json("[{id:1,name:Item1,price:10,quantity:10}, {id:1,name:Item1,price:10,quantity:10}]"))
        // Esto si se puede que solo evalue un objeto .andExpect(content().json("[{id:1,name:Item1,price:10,quantity:10}, {}]"))
        .andExpect(content().json(
            "[{id:1,name:Item1,price:10,quantity:10}, {id:2,name:Item2,price:20,quantity:30}]"))
        .andReturn();
  }
}