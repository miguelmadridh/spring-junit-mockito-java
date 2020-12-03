package com.unittesting.inittesting.bussines;

import com.unittesting.inittesting.data.ItemRepository;
import com.unittesting.inittesting.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemBussinessService {

  @Autowired
  ItemRepository itemRepository;


  public Item retrieveHardCodedItem() {
    return new Item(1, "Ball", 10, 100);
  }


  public List<Item> retrieveAllItems() {
    List<Item> itemList = itemRepository.findAll();
    for (Item item : itemList) {
      item.setValue(item.getPrice() * item.getQuantity());
    }
    return itemList;
  }
}
