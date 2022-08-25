package com.example.demoproject.repository;

import com.example.demoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select u from Product u WHERE u.price = 10000")
    List<Product> findAllByPriceLessThanEqual(Integer price);
}
