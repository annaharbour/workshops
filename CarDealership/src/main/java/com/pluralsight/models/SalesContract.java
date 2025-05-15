package com.pluralsight.models;

import java.math.BigDecimal;

public class SalesContract extends Contract{
    private BigDecimal salesTaxAmount;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold){
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = BigDecimal.valueOf(.05); // multiply by total price
        this.recordingFee = BigDecimal.valueOf(100);
        this.processingFee = this.getVehicleSold().getPrice() > 10000 ? BigDecimal.valueOf(295): BigDecimal.valueOf(495);
    }
}
