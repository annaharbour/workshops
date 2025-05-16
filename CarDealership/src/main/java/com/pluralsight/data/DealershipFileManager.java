package com.pluralsight.data;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager extends FileManager<Dealership> {
    private final String delimiter = "|";

    public DealershipFileManager() {
        super("CarDealership\\data\\inventory.csv");
    }

    @Override
    public Dealership load() {
        //read csv
        List<String> lines = readFile();
        //create dealership object
        if (lines.size() < 2) {
            throw new IllegalStateException("Dealership info is missing from file.");
        }
        String[] dealershipInfo = lines.get(1).split(delimiter);
        String dealershipName = dealershipInfo[0];
        String dealershipAddress = dealershipInfo[1];
        String dealershipPhone = dealershipInfo[2];
        Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
        //skipping headers and directory info
        for (String line : lines.subList(3, lines.size())) {
            //populate the inventory with list of vehicles
            String[] parts = line.split("\\" + delimiter);
            if (parts.length < 8) {
                throw new IllegalStateException("Vehicle info is missing from file");
            }
            int vin = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);
            String make = parts[2];
            String model = parts[3];
            String vehicleType = parts[4];
            String color = parts[5];
            int miles = Integer.parseInt(parts[6]);
            double cost = Double.parseDouble(parts[7]);
            dealership.addVehicle(vin, year, make, model, vehicleType, color, miles, cost);

        }
        return dealership;
    }

    @Override
    public void save(Dealership dealership) {
        List<String> lines = new ArrayList<>();
        lines.add("Dealership Name|Address|Phone");
        lines.add(dealership.getName() + delimiter + dealership.getAddress() + delimiter + dealership.getPhone());
        lines.add("Vin|Year|Make|Model|Vehicle Type|Color|Miles|Cost");
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            lines.add(vehicle.getVin() + delimiter + vehicle.getYear() + delimiter + vehicle.getMake() + delimiter +
                    vehicle.getModel() + delimiter + vehicle.getVehicleType() + delimiter + vehicle.getColor() + delimiter +
                    vehicle.getOdometer() + delimiter + vehicle.getPrice());
        }
        writeFile(lines, delimiter);
    }
}