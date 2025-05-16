package com.pluralsight.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {
    private BigDecimal salesTaxAmount;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,
                         boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = BigDecimal.valueOf(.05);
        this.recordingFee = BigDecimal.valueOf(100);
        this.processingFee =
                this.getVehicleSold().getPrice().compareTo(BigDecimal.valueOf(10000)) > 0 ?
                        BigDecimal.valueOf(295) :
                        BigDecimal.valueOf(
                                495);
        this.isFinanced = isFinanced;
    }

    public BigDecimal getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(BigDecimal salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.getOriginalPrice().add(recordingFee).add(processingFee).add(
                salesTaxAmount.multiply(this.getOriginalPrice()));
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        // It is possible that getMonthlyPayment() would return 0 if they chose the NO loan option.
        if (!isFinanced) return BigDecimal.valueOf(0);

        BigDecimal interestRate = BigDecimal.valueOf(.0525);
        ;
        // Loans are at 5.25% for 24 month
        int months = 24;
        // If the price is $10,000 or more, loans are at 4.25% for 48 months
        if (getTotalPrice().compareTo(BigDecimal.valueOf(10000)) > 0) {
            interestRate = BigDecimal.valueOf(.0425);
            months = 48;
        }

        return getTotalPrice().divide(BigDecimal.valueOf(months), RoundingMode.HALF_EVEN).add(
                interestRate.multiply(getTotalPrice()).divide(BigDecimal.valueOf(months),
                        RoundingMode.HALF_EVEN));
    }


    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", isFinanced=" + isFinanced +
                ", monthlyPayment=" + this.getMonthlyPayment() +
                '}';
    }
}
