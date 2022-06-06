package com.nttdata.createProduct.service;


import org.springframework.stereotype.Service;

import com.nttdata.createProduct.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ProductService {
    Flux<Product> getAll();
    Mono<Product> createProduct(Product new_product);
    Mono<Product> createWallet(Product new_product);    
    Mono<Product> getProductData(String id);
    Mono<Product> updateProduct(Product product,String id);
    Mono<Void> deleteProduct(String id);
    Mono<Product> setInactiveProduct(String id);
}
