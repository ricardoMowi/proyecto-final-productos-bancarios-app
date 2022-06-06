package com.nttdata.createProduct.controller;


import com.nttdata.createProduct.entity.Product;
import com.nttdata.createProduct.entity.eWallet;
import com.nttdata.createProduct.service.ProductService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;
    
    //CRUD
    
     @GetMapping(value = "/all")
	@TimeLimiter(name="createTime")
	@CircuitBreaker(name="createCircuit")
    public Flux<Product> getAll() {
        return productService.getAll();
    } 
     
        
    @PutMapping("/update/{id}")
	@TimeLimiter(name="createTime")
	@CircuitBreaker(name="createCircuit")
    public Mono<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product temp) {
      return productService.updateProduct(temp, id);
  
    }
    
    @PutMapping("setInactive/{id}")
	@TimeLimiter(name="createTime")
	@CircuitBreaker(name="createCircuit")
    public Mono<Product> setInactive(@PathVariable("id") String id) {
      return productService.setInactiveProduct(id);

    } 
    
  
   
    //Microservicio para crear cuentas
    @PostMapping("createProduct")
    @ResponseBody
	@TimeLimiter(name="createTime")
	@CircuitBreaker(name="createCircuit")
    public Mono<Product> createProduct(@RequestBody Product new_product){
 
        return productService.createProduct(new_product);
    }

    //Microservicio para crear cuentas
    @PostMapping("createWallet")
    @ResponseBody
    @TimeLimiter(name="createTime")
    @CircuitBreaker(name="createCircuit")
    public Mono<Product> createWallet(@RequestBody Product new_product){    
        return productService.createWallet(new_product);
    }


}