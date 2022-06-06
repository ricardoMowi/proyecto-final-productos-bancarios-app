package com.nttdata.createProduct.api;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private String customerType;
    private String name;
    private String lastName;
    private String RUC;
    private String address;
    private String email;
    private String status; 
}
