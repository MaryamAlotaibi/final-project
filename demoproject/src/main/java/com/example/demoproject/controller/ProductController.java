package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.exception.InvalidIdException;
import com.example.demoproject.model.Product;
import com.example.demoproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class ProductController {
    private final ProductService productService;


    @GetMapping("products")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @GetMapping("product/{price}")
    public ResponseEntity<Object> findAllByPriceLessThanEqual(@PathVariable Integer price){
        return ResponseEntity.status(200).body(productService.findAllByPriceLessThanEqual(price));
    }

    @PostMapping("add-product")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("New product added ",201));
    }

    @PutMapping("update-product/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody @Valid Product product,@PathVariable Integer id) throws InvalidIdException {
        productService.updateProduct(product,id);
        return ResponseEntity.status(200).body(new ApiResponse("Product is updated",201));
    }

    @DeleteMapping("delete-product/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id) throws InvalidIdException {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body(new ApiResponse("Product is deleted",201));
    }

}
