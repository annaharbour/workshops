package com.pluralsight.dealership.DealershipAPI.model;

import java.time.LocalDate;

public class Sale extends Contract {
    private boolean isFinanced;

    public Sale(int id, String name, String email, String phone, String vin,
                boolean isFinanced) {
        super(id, name, email, phone, vin);
        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
