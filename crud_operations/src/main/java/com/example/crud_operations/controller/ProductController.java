package com.example.crud_operations.controller;

/**
 * TODO anndebna This type ...
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_operations.model.Product;
import com.example.crud_operations.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping(value = "/list")
  public List<Product> getCouponDetails() {

    List<Product> list = this.productService.findAll();
    return list;

  }

  @DeleteMapping(value = "/deleteById/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") String id) {

    this.productService.deleteById(id);
    return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
  }

  @PostMapping(value = "/add")
  public ResponseEntity<String> insertDetails(@RequestBody Product product) {

    System.out.println("product Details Saved");
    this.productService.save(product);
    return new ResponseEntity<String>("Success", HttpStatus.OK);

  }

  @PutMapping("/updateById/{id}")
  public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

    Product p = this.productService.findById(id);

    p.setId(product.getId());

    p.setName(product.getName());
    p.setPrice(product.getPrice());

    this.productService.save(p);
    return p;

  }

}
