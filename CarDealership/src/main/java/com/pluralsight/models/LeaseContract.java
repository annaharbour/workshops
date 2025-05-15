package com.pluralsight.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {
    private BigDecimal originalPrice;
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,
                         BigDecimal originalPrice) {
        super(date, customerName, customerEmail, vehicleSold);
        this.originalPrice = originalPrice;
        this.expectedEndingValue = originalPrice.multiply(BigDecimal.valueOf(0.5));
        this.leaseFee = originalPrice.multiply(BigDecimal.valueOf(0.07));
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return originalPrice.add(leaseFee);
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