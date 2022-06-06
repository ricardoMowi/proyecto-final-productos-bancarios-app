package com.nttdata.createProduct.service;





import org.springframework.stereotype.Service;

import com.nttdata.createProduct.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {
	
	Flux<Customer>  getAll();
    Mono<Customer> createCustomer(Customer new_customer);
    Mono<Customer> getCustomerData(String id);
    Mono<Customer> updateCustomer(Customer Customer,String id);
    Mono<Void> deleteCustomer(String id);
    Mono<Customer> setInactiveCustomer(String id);
}
