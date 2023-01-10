package com.example.crud_operations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_operations.model.Product;
import com.example.crud_operations.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product save(Product product) {

    return this.productRepository.save(product);

  }

  public void deleteById(String id) {

    this.productRepository.deleteById(id);
  }

  public List<Product> findAll() {

    List<Product> list = new ArrayList<>();
    this.productRepository.findAll().forEach(list::add);
    return list;
  }

  public Product findById(String id) {

    return this.productRepository.findById(id).get();
  }

}
