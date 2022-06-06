package com.nttdata.createProduct.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.createProduct.entity.MasterValues;

public interface MasterValueRepository extends ReactiveMongoRepository <MasterValues, String> {
    
}
