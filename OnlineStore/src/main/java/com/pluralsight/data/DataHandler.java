package com.pluralsight.data;

public abstract class DataHandler {
//    TODO load state from products.csv
    public static DataHandler createHandler(){
        return new FileHandler();
    }
}
