package com.pluralsight.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Contract {
    private LocalDate date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private BigDecimal price;

    public Contract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.price = this.vehicleSold.getPrice();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public BigDecimal getOriginalPrice(){
        return this.price;
    }

    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
