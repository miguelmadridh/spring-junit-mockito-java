package com.unittesting.inittesting.controller;

import com.unittesting.inittesting.bussines.ItemBussinessService;
import com.unittesting.inittesting.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @Autowired
  private ItemBussinessService itemBussinessService;

  @GetMapping("/dummy-item")
  public Item dummyItem() {
    return new Item(1, "Ball", 10, 100);
  }

  @GetMapping("/item-from-business-service")
  public Item itemFromBussinesService() {
    return itemBussinessService.retrieveHardCodedItem();
  }

  @GetMapping("/item-from-database")
  public List<Item> itemFromDatabase() {
    return itemBussinessService.retrieveAllItems();
  }

}
