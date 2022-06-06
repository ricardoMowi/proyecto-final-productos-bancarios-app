package com.nttdata.createProduct.redis.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;


import com.nttdata.createProduct.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerCache implements Serializable{
	
    private String id;
    private String customerType;
    private String name;
    private String lastName;
    private String RUC;
    private String address;
    private String email;
    private String status; 
	
	public static CustomerCache fromCustomerResponse(Customer customer) {
		return CustomerCache.builder()
				.id(customer.getId())
				.customerType(customer.getCustomerType())
				.name(customer.getName())
				.lastName(customer.getLastName())
				.RUC(customer.getRUC())
				.address(customer.getAddress())
				.email(customer.getEmail())
				.status(customer.getStatus())
				.build();
				
	}
}
