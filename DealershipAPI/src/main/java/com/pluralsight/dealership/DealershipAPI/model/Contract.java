package com.pluralsight.dealership.DealershipAPI.model;

import java.time.LocalDate;

public abstract class Contract {
    private int id;
    private String customer;
    private String phone;
    private String email;
    private String vin;

    public Contract(int id, String customer, String phone, String email, String vin) {
        this.id = id;
        this.phone = phone;
        this.customer = customer;
        this.email = email;
        this.vin = vin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setCustomerEmail(String email) {
        this.email = email;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vehicle){
        this.vin = vin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}