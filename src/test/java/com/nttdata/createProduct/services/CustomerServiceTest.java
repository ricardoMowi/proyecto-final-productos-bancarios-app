package com.nttdata.createProduct.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nttdata.createProduct.entity.Customer;
import com.nttdata.createProduct.repository.CustomerRepository;
import com.nttdata.createProduct.service.Impl.CustomerServiceImpl;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerServiceTest {

	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerService;

	private Customer customerToTest;
	
	private  List<Customer> lista;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		lista = new ArrayList<>();
		
		
		customerToTest=Customer.builder()
				.id("123")
				.customerType("BUSINESS")
				.name("Diego")
				.lastName("Silva")
				.RUC("1234354654")
				.address("Jr lurigancho 123")
				.email("email@gmail.com")
				.status("ACTIVE")
				.build();
		lista.add(customerToTest);
	}
	
	@Test
	void createTest() {

		when(customerRepository.save(any(Customer.class))).thenReturn(Mono.just(customerToTest));
		assertNotNull(customerService.createCustomer(customerToTest));
		
	}
	
	@Test
	void deleteTest() {
		when(customerRepository.deleteById("123")).thenReturn(null);
		assertNull(customerService.deleteCustomer("123"));
		
	}
	
	@Test
	void getByIdTest() {
		when(customerRepository.findById("123")).thenReturn(Mono.just(customerToTest));
		assertNotNull(customerService.getCustomerData("123"));
		
	}
	
	@Test
	void updateTest() {
		when(customerRepository.findById("123")).thenReturn(Mono.just(customerToTest));
		when(customerRepository.save(customerToTest)).thenReturn(Mono.just(customerToTest));
		assertNotNull(customerService.updateCustomer(new Customer(),"123"));
		
	}
	
	@Test
	void getAllTest() {
		when(customerRepository.findAll()).thenReturn(Flux.fromIterable(lista));
		assertNotNull(customerService.getAll());
		
	}
}
