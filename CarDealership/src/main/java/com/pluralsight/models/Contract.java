package com.pluralsight.models;

import java.math.BigDecimal;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private BigDecimal price;
    private BigDecimal monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.price = BigDecimal.valueOf(vehicleSold.getPrice());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return this.vehicleSold;
    }

    public void setSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public BigDecimal getTotalPrice(){
        return new BigDecimal(0);
    }

    public BigDecimal getMonthlyPayment(){
        return new BigDecimal(0);
    }
}
