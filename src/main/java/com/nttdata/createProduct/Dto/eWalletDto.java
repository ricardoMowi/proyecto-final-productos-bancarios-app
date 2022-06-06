package com.nttdata.createProduct.Dto;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class eWalletDto {
    public String id;
    public Date creationDate;
    public Double amount;
    public String productType;
    public String status;
    public String identificationCode;
    public String phoneNumber;
    public String IMEIPhone;
    public String email;
}