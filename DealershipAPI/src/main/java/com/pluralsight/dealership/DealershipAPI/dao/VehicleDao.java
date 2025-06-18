package com.pluralsight.dealership.DealershipAPI.dao;

import com.pluralsight.dealership.DealershipAPI.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getByPrice(double minPrice, double maxPrice);
    List<Vehicle> getByMakeModel(String make, String model);
    List<Vehicle> getByYear(int minYear, int maxYear);
    List<Vehicle> getByMileage(int minMileage, int maxMileage);
    List<Vehicle> getByType(String type);
    List<Vehicle> getByColor(String color);

    Vehicle updateVehicle(String vin, Vehicle vehicle);
    Vehicle addVehicle(Vehicle vehicle);

    void deleteVehicle(String vin);
}
