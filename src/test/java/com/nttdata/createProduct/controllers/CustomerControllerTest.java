package com.nttdata.createProduct.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



import java.util.ArrayList;
import java.util.List;



import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import com.nttdata.createProduct.controller.CustomerController;
import com.nttdata.createProduct.entity.Customer;
import com.nttdata.createProduct.service.Impl.CustomerServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@WebFluxTest(CustomerController.class)
public class CustomerControllerTest {

	@MockBean
	private CustomerServiceImpl customerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	//@Autowired 
	//private WebTestClient webTestClient;
	
	private Customer customerToTest;
	
	private List<Customer> lista;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		lista= new ArrayList<>();
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
	public void createCustomerTest() throws Exception {
		//Customer customer=new Customer("123","BUSINESS","Diego","Silva","1234354654","Jr lurigancho 123","email@gmail.com","ACTIVE");
		
		//when(customerService.createCustomer(customerToTest)).thenReturn(Mono.just(customerToTest));
		
			/*webTestClient.post().uri("/client/create")
			.contentType(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk();*/
			
	}
	
	@Test
	public void getAllTest() throws Exception {
		//when(customerService.getAll()).thenReturn(Flux.fromIterable(lista));
		
		//this.mockMvc.perform(get("/client/all"))
		//.andExpect(status().isOk());
	}
	
	
}
