package com.nttdata.createProduct.repository;

import com.nttdata.createProduct.entity.Product;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
	Flux<Product> findByCustomerId(String customerId);
    Flux<Product> findByProductTypeAndStatus(String ProductType, String Status);
    Flux<Product> findByProductTypeAndCustomerId (String ProductType, String customerId);    
    Flux<Product> findByHasDebt ();  
}
