package com.pluralsight.dealership.DealershipAPI.model;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int mileage;
    private double price;

    public Vehicle(String vin, int year, String make, String model, String type, String color, int mileage,
                   double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return type;
    }

    public void setVehicleType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return mileage;
    }

    public void setOdometer(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "\nVEHICLE" +
                "\n\tVin: " + vin +
                "\n\tYear: " + year +
                "\n\tMake: '" + make + '\'' +
                "\n\tModel: '" + model + '\'' +
                "\n\tVehicle Type: '" + type + '\'' +
                "\n\tColor: '" + color + '\'' +
                "\n\tMileage: " + mileage +
                "\n\tPrice: $" + String.format("%.2f", price);
    }

}
