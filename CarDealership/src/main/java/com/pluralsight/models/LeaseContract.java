package com.pluralsight.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class LeaseContract extends Contract {
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = this.getOriginalPrice().multiply(BigDecimal.valueOf(0.5));
        this.leaseFee = this.getOriginalPrice().multiply(BigDecimal.valueOf(0.07));
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }


    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }


    @Override
    public BigDecimal getTotalPrice() {
        return this.getOriginalPrice().add(leaseFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal residualValue = getTotalPrice().subtract(expectedEndingValue);
        BigDecimal interestRate = BigDecimal.valueOf(0.04);
        int months = 36;
        return residualValue.add(residualValue.multiply(interestRate)).divide(BigDecimal.valueOf(months),
                RoundingMode.HALF_EVEN);
    }
}