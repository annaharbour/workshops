package com.pluralsight.controller;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager extends FileManager<Dealership> {
    private String path = "data";
    private String fileName = "inventory.csv";
    private final String delimiter = ",";

    public DealershipFileManager(String path, String fileName) {
        super(path, fileName);
    }

    public Dealership load(){
        return getDealership();
    }

    public void save(Dealership dealership){
        saveDealership(dealership);
    }

    public Dealership getDealership() {
        //read csv
        List<String> lines = readFile();
        if (lines.size() < 3) {
            throw new IllegalStateException("File format is invalid or missing data.");
        }
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
//                TODO: add vehicles to dealership model
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, miles, cost);
                dealership.addVehicle(vehicle);
            }
        }
        return dealership;
    }


    // After
    public void saveDealership(Dealership dealership) {
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
}
