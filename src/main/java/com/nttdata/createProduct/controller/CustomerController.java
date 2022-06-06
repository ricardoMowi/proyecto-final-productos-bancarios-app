package com.nttdata.createProduct.controller;


import com.nttdata.createProduct.entity.Customer;
import com.nttdata.createProduct.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/client")
public class CustomerController {
    
	@Autowired
    private CustomerService customerService;

    //CRUD
    @GetMapping(value = "/all")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Flux<Customer> getAll() {
        log.info("lista todos");
        return customerService.getAll();
    }  

    @GetMapping("getClient/{id}")
    @ResponseBody
    @TimeLimiter(name="consultTime")
    @CircuitBreaker(name="consultCircuit")
    public Mono<Customer> getCustomerData(@PathVariable("id") String id){
      
    	return customerService.getCustomerData(id);
   
    }


    
    @PostMapping(value = "/create")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<Customer> createCustomer(@RequestBody Customer new_client){
       
        return customerService.createCustomer(new_client);
    }

    
    @PutMapping("/update/{id}")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer temp) {
    	return customerService.updateCustomer(temp, id);
   
    }
    
    
    @PutMapping("setInactive/{id}")
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<Customer> setInactive(@PathVariable("id") String id/*, @RequestBody Client temp_client*/) {
      return customerService.setInactiveCustomer(id);
 
    } 


}