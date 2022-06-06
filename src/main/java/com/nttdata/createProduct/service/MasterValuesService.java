package com.nttdata.createProduct.service;

import org.springframework.stereotype.Service;

import com.nttdata.createProduct.entity.MasterValues;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface MasterValuesService {
    Flux<MasterValues>  getAll();
    Mono<MasterValues> createMasterValue(MasterValues newMasterValue);
    Mono<MasterValues> getMasterValue(String id);
    Mono<MasterValues> updateMasterValue(MasterValues temp,String id);
    Mono<Void> deleteMasterValue(String id);
    Mono<MasterValues> setInactiveMasterValue(String id);
}
