package com.pluralsight.dealership.DealershipAPI.model;

import java.time.LocalDate;

public class Lease extends Contract {

    public Lease(int id, String customer, String phone, String email, String vin) {
        super(id, customer, phone, email, vin);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

}
