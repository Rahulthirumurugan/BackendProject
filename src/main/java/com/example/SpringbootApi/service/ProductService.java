package com.example.SpringbootApi.service;

import com.example.SpringbootApi.dto.ProductDTO;
import com.example.SpringbootApi.entity.Product;
import com.example.SpringbootApi.entity.ResponseObject;

import java.util.List;
import java.util.Optional;

public interface ProductService{

    Product saveProductDetails(Product product);

    public List<ProductDTO> getProducts();

//    Product updateProductById(int productId);

    Product findByProductName(String productName);

     Product deleteProduct(String productName);

    Product findProductById(int productId);
}
