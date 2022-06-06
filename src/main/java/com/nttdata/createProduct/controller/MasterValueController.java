package com.nttdata.createProduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.createProduct.entity.MasterValues;
import com.nttdata.createProduct.service.MasterValuesService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/mastervalues")
public class MasterValueController {
    @Autowired
    private MasterValuesService service;

    //CRUD
    @GetMapping(value = "/all")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Flux<MasterValues> getAll() {
        log.info("lista todos");
        return service.getAll();
    }  

    @GetMapping("getClient/{id}")
    @ResponseBody
    @TimeLimiter(name="consultTime")
    @CircuitBreaker(name="consultCircuit")
    public Mono<MasterValues> getMasterValue(@PathVariable("id") String id){
      
    	return service.getMasterValue(id);
   
    }


    
    @PostMapping(value = "/create")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<MasterValues> createMasterValue(@RequestBody MasterValues new_client){
       
        return service.createMasterValue(new_client);
    }

    
    @PutMapping("/update/{id}")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<MasterValues> updateMasterValue(@PathVariable("id") String id, @RequestBody MasterValues temp) {
    	return service.updateMasterValue(temp, id);
   
    }
    
    
    @PutMapping("setInactive/{id}")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<MasterValues> setInactiveMasterValue(@PathVariable("id") String id/*, @RequestBody Client temp_client*/) {
      return service.setInactiveMasterValue(id);
 
    } 
}
