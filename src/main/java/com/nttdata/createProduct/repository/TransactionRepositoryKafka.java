package com.nttdata.createProduct.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.createProduct.entity.Transaction;

public interface TransactionRepositoryKafka extends MongoRepository <Transaction, String>{
    
}











