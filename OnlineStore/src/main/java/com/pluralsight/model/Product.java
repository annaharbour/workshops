package com.pluralsight.model;

public class Product {
    private String id;
    private String productName;
    private enum department {
        Electronics,
        Games,
        Computers,
        AudioVideo
    };
    private department department;
    private float price;

    public Product(String id, String productName, department department, float price) {
        this.id = id;
        this.productName = productName;
        this.department = department;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getProductName() {
        return this.productName;
    }


    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        this.department = department;
    }

    public float getPrice() {
        return this.price;
    }
}
