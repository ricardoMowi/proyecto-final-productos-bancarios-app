package com.nttdata.createProduct.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

@Document(collection="customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer implements Serializable {
    @Id
    private String id;
    private String customerType;
    private String name;
    private String lastName;
    private String RUC;
    private String address;
    private String email;
    private String status; 
}
