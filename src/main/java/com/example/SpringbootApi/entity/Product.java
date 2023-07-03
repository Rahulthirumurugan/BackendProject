package com.example.SpringbootApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "ProductName")
    private String productName;

    @Column(name = "deleteId")
    private int deletevalue;

    public int getDeletevalue() {
        return deletevalue;
    }

    public void setDeletevalue(int deletevalue) {
        this.deletevalue = deletevalue;
    }

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "dept_id")
    @JsonBackReference
    private Department department;

    public Product(String productName,int deletevalue) {

        this.productName = productName;
        this.deletevalue = deletevalue;

    }

    public Product(){}
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", department=" + department +
                '}';
    }
}
