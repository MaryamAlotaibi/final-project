package com.example.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username is required !")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "Password is required !")
    private String password;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "(Admin|Customer)")
    private String role;
    @NotNull(message = "balance is required")
    private Integer balance;



}
