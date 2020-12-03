package com.unittesting.inittesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class Item {

  @Id
  private int id;
  private String name;
  private int price;
  private int quantity;
  @Transient
  private int value;

  public Item(){}

  public Item(int id, String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }


  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", quantity=" + quantity +
        '}';
  }
}
