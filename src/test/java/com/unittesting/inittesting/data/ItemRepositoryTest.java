package com.unittesting.inittesting.data;

import static org.junit.Assert.assertEquals;

import com.unittesting.inittesting.model.Item;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

  @Autowired
  ItemRepository itemRepository;

  @Test
  public void findAll_test() {
    List<Item> all = itemRepository.findAll();
    assertEquals(10, all.size());
  }
}