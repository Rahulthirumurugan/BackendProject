package com.example.SpringbootApi.repository;

import com.example.SpringbootApi.entity.Product;
import com.example.SpringbootApi.entity.ResponseObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByProductName(String productName);



}
