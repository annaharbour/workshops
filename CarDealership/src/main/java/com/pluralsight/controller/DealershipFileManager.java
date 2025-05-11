package com.pluralsight.controller;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager extends FileManager<Dealership> {
    private final String delimiter = ",";

    public DealershipFileManager(String path, String fileName) {
        super("C:\\Users\\Anna Harbour\\Documents\\Coding\\pluralsight\\workshops\\CarDealership\\src\\main\\java" +
                "\\com\\pluralsight\\data\\inventory.csv");
    }

    public Dealership load() {
        //read csv
        List<String> lines = readFile();
        //create dealership object
        String[] dealershipInfo = lines.get(1).split(delimiter);
        String dealershipName = dealershipInfo[0];
        String dealershipAddress = dealershipInfo[1];
        String dealershipPhone = dealershipInfo[2];
        Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
        //populate the inventory with list of vehicles
        for (String line : lines.subList(3, lines.size())) {
            String[] parts = line.split(delimiter);
            if (parts.length == 8) {
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int miles = Integer.parseInt(parts[6]);
                double cost = Double.parseDouble(parts[7]);
                // Add vehicles to dealership model
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, miles, cost);
                dealership.addVehicle(vehicle);
            }
        }
        return dealership;
    }

    public void save(Dealership dealership) {
        List<String> lines = new ArrayList<>();
        lines.add("Dealership Name,Address,Phone");
        lines.add(dealership.getName() + delimiter + dealership.getAddress() + delimiter + dealership.getPhone());
        lines.add("Vin,Year,Make,Model,Vehicle Type,Color,Miles,Cost");
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            lines.add(vehicle.getVin() + delimiter + vehicle.getYear() + delimiter + vehicle.getMake() + delimiter +
                    vehicle.getModel() + delimiter + vehicle.getVehicleType() + delimiter + vehicle.getColor() + delimiter +
                    vehicle.getOdometer() + delimiter + vehicle.getPrice());
        }
        writeFile(lines, delimiter);
    }

    public Dealership getDealership() {
        return load();
    }

    public void saveDealership(Dealership dealership) {
        save(dealership);
    }
}