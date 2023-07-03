package com.example.SpringbootApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ResponseObject {
    @Id
    private String productName;
    private String deptName;
   private int deleteValue;
    public ResponseObject() {
    }

    public ResponseObject(String productName, String deptName,int deleteValue) {
        this.productName = productName;
        this.deptName = deptName;
        this.deleteValue = deleteValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeleteValue() {
        return deleteValue;
    }

    public void setDeleteValue(int deleteValue) {
        this.deleteValue = deleteValue;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "productName='" + productName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
