package com.nttdata.createProduct.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.createProduct.entity.Transaction;

public interface TransactionRepository extends ReactiveMongoRepository <Transaction, String>{
    
}
