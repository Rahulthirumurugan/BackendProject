package com.example.SpringbootApi.dto;

public class ProductDTO {
    private int productId;
    private String productName;
    private int deletevalue;
    private String deptName;

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

    public int getDeletevalue() {
        return deletevalue;
    }

    public void setDeletevalue(int deletevalue) {
        this.deletevalue = deletevalue;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
