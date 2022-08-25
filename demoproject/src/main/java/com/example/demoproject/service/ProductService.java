package com.example.demoproject.service;

import com.example.demoproject.exception.InvalidIdException;
import com.example.demoproject.model.Product;
import com.example.demoproject.repository.MerchantStockRepository;
import com.example.demoproject.repository.ProductRepository;
import com.example.demoproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final MerchantStockRepository merchantStockRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public  ArrayList<Product>getProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product, Integer id) throws InvalidIdException {
        Product product1 = productRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid product id"));
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) throws InvalidIdException {
        Product product1 = productRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid product id"));
        productRepository.deleteById(id);
    }

    public List<Product> findAllByPriceLessThanEqual(Integer price) {
        return productRepository.findAllByPriceLessThanEqual(price);

    }

}
