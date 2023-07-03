package com.example.SpringbootApi.dto;

import com.example.SpringbootApi.entity.Product;
import java.util.*;

public class DepartmentDTO {
    private int deptId;
    private String deptName;

    private List<Product> products;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +

                '}';
    }
}
