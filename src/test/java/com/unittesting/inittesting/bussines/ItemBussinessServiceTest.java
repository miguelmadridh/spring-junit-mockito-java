package com.unittesting.inittesting.bussines;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.unittesting.inittesting.data.ItemRepository;
import com.unittesting.inittesting.model.Item;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemBussinessServiceTest {

  @InjectMocks
  ItemBussinessService itemBussinessService;

  @Mock
  ItemRepository itemRepository;

  @Test
  public void retrieveAllItems() {

    when(itemRepository.findAll()).thenReturn(
        Arrays.asList(
            new Item(1, "Item1", 10, 10),
            new Item(2, "Item2", 20, 30)
        )
    );
    List<Item> items = itemBussinessService.retrieveAllItems();
    assertEquals(100, items.get(0).getValue());
    assertEquals(600, items.get(1).getValue());


  }
}