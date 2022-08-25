package com.example.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {

    @Id
    private Integer id;

    @NotEmpty(message = "Product ID has to be not empty")
    @Size(min=3,message="Product ID has to be at least 3 char long")
    private String productID;

    @NotEmpty(message = "Merchant ID has to be not empty")
    @Size(min=3,message="Merchant ID has to be at least 3 length long")
    private String merchantID;

    @NotEmpty(message = "Stock has to be not empty")
    @Min(message = "Stock has to be more than 10 at start", value = 11)
    private String stock;

}
