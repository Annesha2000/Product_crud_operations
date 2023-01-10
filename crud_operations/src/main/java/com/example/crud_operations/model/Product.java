package com.example.crud_operations.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Product {
  @Id
  private String id;

  @Field
  private String name;

  @Field
  private int price;

  /**
   * The constructor.
   */
  public Product() {

    super();
  }

  /**
   * The constructor.
   *
   * @param id
   * @param name
   * @param price
   */
  public Product(String id, String name, int price) {

    super();
    this.id = id;
    this.name = name;
    this.price = price;
  }

  /**
   * @return id
   */
  public String getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(String id) {

    this.id = id;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return price
   */
  public int getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  public void setPrice(int price) {

    this.price = price;
  }

  @Override
  public String toString() {

    return "Product [id=" + this.id + ", name=" + this.name + ", price=" + this.price + "]";
  }

}
