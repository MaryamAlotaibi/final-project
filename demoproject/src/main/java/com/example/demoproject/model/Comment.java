package com.example.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_id")
    @NotNull(message = "productId is required")
    private Integer productId;

    @NotEmpty(message = "message is required")
    @Size(min = 3, message = "message have to be 6 length long")
    private String message;

    @NotNull(message = "rate is required")
    @Range(min = 0, max = 5, message = "rate must be a number between 0 - 5")
    private Integer rate = 0;


}
