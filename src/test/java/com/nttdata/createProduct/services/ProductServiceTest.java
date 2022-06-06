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
import com.nttdata.createProduct.entity.Product;
import com.nttdata.createProduct.repository.CustomerRepository;
import com.nttdata.createProduct.repository.ProductRepository;
import com.nttdata.createProduct.service.Impl.ProductServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private ProductServiceImpl productService;
	
	private Product productToTest;
	
	private Customer customerToTest;
	
	private  List<Product> lista;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		lista = new ArrayList<>();
		productToTest=Product.builder()
				.id("1234")
				.customerId("123")
				.creationDate(null)
				.transactionDate(null)
				.maximumTransactionLimit(3)
				.numberOfFreeTransactions(1)
				.maintenanceCommission(5.00)
				.amount(99.9)
				.productType("BUSINESS_CREDIT")
				.status("ACTIVE")
				.owners(null)
				.authorizedSigner(null)
				.build();
		
		
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
		lista.add(productToTest);
	}
	
	@Test
	void createTest() {
		when(productRepository.findByProductTypeAndCustomerId(any(), any())).thenReturn(Flux.fromIterable(lista));
		when(customerRepository.findById("123")).thenReturn(Mono.just(customerToTest));
		when(productRepository.save(any(Product.class))).thenReturn(Mono.just(productToTest));
		assertNotNull(productService.createProduct(productToTest));
		
	}
	
	@Test
	void deleteTest() {
		when(productRepository.deleteById("123")).thenReturn(null);
		assertNull(productService.deleteProduct("123"));
		
	}
	
	@Test
	void getByIdTest() {
		when(productRepository.findById("123")).thenReturn(Mono.just(productToTest));
		assertNotNull(productService.getProductData("123"));
		
	}
	
	@Test
	void updateTest() {
		when(productRepository.findById("123")).thenReturn(Mono.just(productToTest));
		when(productRepository.save(productToTest)).thenReturn(Mono.just(productToTest));
		assertNotNull(productService.updateProduct(new Product(),"123"));
		
	}
	
	@Test
	void getAllTest() {
		when(productRepository.findAll()).thenReturn(Flux.fromIterable(lista));
		assertNotNull(productService.getAll());
		
	}
	
}
