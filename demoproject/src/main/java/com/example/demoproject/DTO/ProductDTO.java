package com.example.demoproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class ProductDTO {
    private Integer cartId;
    private String name;
    private Integer price;
}
