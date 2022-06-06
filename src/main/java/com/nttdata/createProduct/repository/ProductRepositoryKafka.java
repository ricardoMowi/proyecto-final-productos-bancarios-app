package com.nttdata.createProduct.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.createProduct.entity.Product;

public interface ProductRepositoryKafka extends MongoRepository <Product, String>{
    
}











