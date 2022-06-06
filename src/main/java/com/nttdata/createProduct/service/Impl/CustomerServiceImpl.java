package com.nttdata.createProduct.service.Impl;


import com.nttdata.createProduct.entity.Customer;
import com.nttdata.createProduct.repository.CustomerRepository;
import com.nttdata.createProduct.service.CustomerService;

// import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



// @Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	private CustomerRepository customerRepository;
	

    
	public Flux<Customer> getAll() {
		return customerRepository.findAll();
	
	}

	public Mono<Customer> getCustomerData(String id) {
		return customerRepository.findById(id);
	}
	
	public Mono<Customer> createCustomer(Customer new_customer) {
		new_customer.setStatus("ACTIVE");
		return customerRepository.save(new_customer);
	}
	

	public Mono<Customer> updateCustomer(Customer customer,String id){
		return customerRepository.findById(id)
				.map(c->{
					c.setAddress(customer.getAddress());
					c.setCustomerType(customer.getCustomerType());
					c.setEmail(customer.getEmail());
					c.setId(id);
					c.setLastName(customer.getLastName());
					c.setName(customer.getName());
					c.setRUC(customer.getRUC());
					c.setStatus("ACTIVE");
					return c;
				}).flatMap(customerRepository::save);
	}
	
	public Mono<Void> deleteCustomer(String id){
		return customerRepository.deleteById(id);
	}
	
	public Mono<Customer> setInactiveCustomer(String id){
		return customerRepository.findById(id)
				.doOnNext(e->e.setStatus("INACTIVE"))
				.flatMap(customerRepository::save);
	}

	/*public String processTransaction(Customer  customer) throws InterruptedException {
		
			if(this.getAll().collectList().block().isEmpty()) {
				this.storageAssuranceList(
						customerApiClient.getList();
						.stream()
						.map(CustomerCache::fromCustomerResponse)
						.collect(Collectors.toList())
					);
				
			}
			log.info("From redis cache"+this.getAllData().toString());
			return "Processing draft ...";
		}

	public Flux<List<Customer>> getAllData() {
		try {
			List<Customer> customerCacheList= new ArrayList<>();
			customerRepository.findAll().collectList().block().forEach(customerCacheList::add);
			return Flux.just(customerCacheList);
		}catch(Exception e) {
			log.error("Error while trying to get assurances from redis cache"+e.getMessage());
			return Flux.just(Collections.EMPTY_LIST);
		}
	}


	public String storageCustomerList(List<CustomerCache> customerCacheList) {
		
		//se saco el iterable del try
		Iterable<CustomerCache> customerCacheIterable= customerCacheList;
		try {
			customerRepository.saveAll(customerCacheIterable);
		return "Customer list create successfully";
		}catch(Exception e) {
			return "Error saving assurance cache list"+e.getMessage();
		}
	}*/
	// public Flux<List<Customer>> getAllData() {
	// 	try {
	// 		List<Customer> customerCacheList= new ArrayList<>();
	// 		customerRepository.findAll().collectList().block().forEach(customerCacheList::add);
	// 		return Flux.just(customerCacheList);
	// 	}catch(Exception e) {
	// 		log.error("Error while trying to get assurances from redis cache"+e.getMessage());
	// 		return Flux.just(Collections.EMPTY_LIST);
	// 	}
	// }

}
