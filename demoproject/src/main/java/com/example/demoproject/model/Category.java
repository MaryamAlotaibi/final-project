package com.example.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Category {
    @Id
    private Integer id;

    @NotEmpty(message = "Name has to be not empty")
    @Size(min=3,message="Name has to be at least 3 length long")
    private String name;
}
