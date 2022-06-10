package com.nttdata.createProduct.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nttdata.createProduct.controller.ProductController;
import com.nttdata.createProduct.entity.Product;
import com.nttdata.createProduct.service.ProductService;

import reactor.core.publisher.Mono;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@MockBean
	private ProductService productService;
		
	@InjectMocks
	private ProductController productController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception{
		/*mockMvc = MockMvcBuilders.standaloneSetup(productController)
				.build();*/
	}
	
	@Test
	public void createProductTest() throws Exception {
		/*Product producttoTest=Product.builder()
				.customerId("123")
				.creationDate(null)
				.transactionDate(null)
				.maximumTransactionLimit(3)
				.numberOfFreeTransactions(1)
				.maintenanceCommission(5.00)
				.amount(99.9)
				.productType("BUSSINESS")
				.status("ACTIVE")
				.owners(null)
				.authorizedSigner(null)
				.build();
		when(productService.createProduct(producttoTest)).thenReturn(Mono.just(producttoTest));
		
		webTestClient.post().uri("/products/createProduct")
			.body(Mono.just(producttoTest), Product.class )
			.exchange()
			.expectStatus().isOk();
		
		mockMvc.perform(post("/product/createProduct")
				.a
				
			*/	
				
		
		
	}

}
