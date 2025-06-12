package com.pluralsight.dealership.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    private List<Vehicle> filterVehicles(java.util.function.Predicate<Vehicle> predicate) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (predicate.test(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return filterVehicles(
                vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(min)) > 0 && vehicle.getPrice().compareTo(
                        BigDecimal.valueOf(max)) <= 0);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return filterVehicles(
                vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model));
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return filterVehicles(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max);
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return filterVehicles(vehicle -> vehicle.getColor().equalsIgnoreCase(color));
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return filterVehicles(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max);
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return filterVehicles(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType));
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(int vin, int year, String make, String model, String vehicleType, String color,
                           int odometer, double price) {
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        inventory.add(vehicle);
    }

    public void removeVehicle(int vin) {
        List<Vehicle> vehiclesToRemove = filterVehicles(vehicle -> vehicle.getVin() == vin);
        if (!vehiclesToRemove.isEmpty()) {
            inventory.remove(vehiclesToRemove.get(0));
        }
    }

    public Vehicle getVehicleByVin(int vin) {
        List<Vehicle> vehicles = filterVehicles(vehicle -> vehicle.getVin() == vin);
        if (!vehicles.isEmpty()) {
            return vehicles.get(0);
        }
        else return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
