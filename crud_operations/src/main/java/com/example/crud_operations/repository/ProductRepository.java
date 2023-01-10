package com.example.crud_operations.repository;

/**
 * TODO anndebna This type ...
 *
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_operations.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
