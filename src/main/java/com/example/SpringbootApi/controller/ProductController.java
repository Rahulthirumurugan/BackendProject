package com.example.SpringbootApi.controller;

import com.example.SpringbootApi.dto.ProductDTO;
import com.example.SpringbootApi.entity.Product;
import com.example.SpringbootApi.entity.Department;
import com.example.SpringbootApi.entity.ResponseObject;
import com.example.SpringbootApi.service.DepartmentService;
import com.example.SpringbootApi.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    private ProductService productService;
    private DepartmentService departmentService;

    public ProductController(ProductService productService, DepartmentService departmentService) {
        this.productService = productService;
        this.departmentService = departmentService;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProductDetails(@RequestBody ResponseObject responseObject) {
        System.out.println(responseObject.toString());
        String productName = responseObject.getProductName();
        int value = responseObject.getDeleteValue();
        System.out.println(value +" valus is:");
        String departmentName = responseObject.getDeptName();

        Product product = new Product(productName,value);
        Department department = departmentService.findByDeptName(departmentName);
        System.out.println(department);
        if (department == null) {
            department = new Department(departmentName);
        }
        product.setDepartment(department);
        return productService.saveProductDetails(product);
    }

    @GetMapping("/listproducts")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody ResponseObject responseObject) {
        System.out.println(responseObject);
        System.out.println(productId);
        String updatedProductName = responseObject.getProductName();
        String updatedDeptName = responseObject.getDeptName();

        Product product = productService.findProductById(productId);
        System.out.println(product);

        if (product != null) {
            product.setProductName(updatedProductName);

            Department department = departmentService.findByDeptName(updatedDeptName);
            if (department == null) {
                department = new Department(updatedDeptName);
            }

            product.setDepartment(department);
            return productService.saveProductDetails(product);
        } else {
            throw new IllegalArgumentException("Product not found with name: " + productId);
        }
    }

    @DeleteMapping("/{productName}")
    public Product deleteProduct(@PathVariable String productName) {
        return productService.deleteProduct(productName);
    }
}




