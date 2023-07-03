package com.example.SpringbootApi.serviceImpl;
import  com.example.SpringbootApi.dto.ProductDTO;

import com.example.SpringbootApi.entity.Product;
import com.example.SpringbootApi.entity.ResponseObject;
import com.example.SpringbootApi.repository.DepartmentRepository;
import com.example.SpringbootApi.repository.ProductRepository;
import com.example.SpringbootApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product saveProductDetails(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getDeletevalue() == 1)
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public Product updateProductById(int productId) {
//        return productRepository.findByProductById(productId);
//    }

    @Override
    public Product findByProductName(String productName) {
        return productRepository.findByProductName(productName);

    }

    @Override
    public Product deleteProduct(String productName) {

        Product product1 = productRepository.findByProductName(productName);
        product1.setProductName(product1.getProductName());
        product1.setDeletevalue(0);

        return productRepository.save(product1);
    }

    @Override
    public Product findProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }


    public ProductDTO convertEntityToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setDeletevalue(product.getDeletevalue());
        productDTO.setProductName(product.getProductName());
        return productDTO;
    }
}
