package com.example.crud_operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.crud_operations.model.Product;
import com.example.crud_operations.repository.ProductRepository;
import com.example.crud_operations.service.ProductService;

@SpringBootTest
class CrudOperationsApplicationTests {

  @Autowired
  private ProductService productService;

  @MockBean
  private ProductRepository productRepository;

  Product product = new Product();

  List<Product> productList = new ArrayList<Product>();

  @BeforeEach
  public void setup() {

    this.product.setId("abcd");
    this.product.setName("speakers");

    this.product.setPrice(1000);

    this.productList.add(this.product);

  }

  @Test
  public void getCouponDetailsTest() {

    Mockito.when(this.productService.findAll()).thenReturn(this.productList);
    assertEquals(1, this.productService.findAll().size());
  }

  @Test
  public void insertDetailsTest() {

    Mockito.when(this.productRepository.save(this.product)).thenReturn(this.product);
    assertEquals(this.product, this.productService.save(this.product));
  }

  @Test
  public void findByIdTest() {

    Mockito.when(this.productRepository.findById("abcd")).thenReturn(Optional.of(this.product));
    assertEquals(this.product, this.productService.findById("abcd"));
  }

  @Test
  public void deleteByIdTest() {

    Mockito.when(this.productRepository.findById("abcd")).thenReturn(Optional.of(this.product));
    this.productService.deleteById("abcd");
    Mockito.verify(this.productRepository, Mockito.times(1)).deleteById("abcd");
  }

}
