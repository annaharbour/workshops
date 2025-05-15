package com.pluralsight.ui;

import com.pluralsight.data.DealershipFileManager;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //        TODO handle incorrect input ie year not 4 digits
    private Dealership dealership;
    private DealershipFileManager dealershipCSVManager;

    public UserInterface() {
        this.dealershipCSVManager = new DealershipFileManager();
        this.dealership = init();
    }

    private Dealership init() {
        dealership = dealershipCSVManager.getDealership();
        return dealership;
    }

    public void displayMenu() {
        String[] menuOptions = {"Find vehicles within price range", "Find vehicles by make / model", "Find " +
                "vehicles by year range", "Find vehicles by color", "Find vehicles by mileage range", "Find vehicles " +
                "by type (truck, SUV, van, car)", "Get all vehicles", "Add a vehicle", "Remove a vehicle", "Quit"};
        System.out.println("Please select from the following menu options: ");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + menuOptions[i]);
        }
    }

    public void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
        };
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    displayVehicles(getByPriceRequest(scanner, dealership));
                }
                case 2 -> {
                    displayVehicles(getByMakeModelRequest(scanner, dealership));
                }
                case 3 -> {
                    displayVehicles(processGetByYearRequest(scanner, dealership));
                }
                case 4 -> {
                    displayVehicles(getByColorRequest(scanner, dealership));
                }
                case 5 -> {
                    displayVehicles(processGetByMileageRequest(scanner, dealership));
                }
                case 6 -> {
                    displayVehicles(processGetByVehicleTypeRequest(scanner, dealership));
                }
                case 7 -> {
                    displayVehicles(processGetAllVehiclesRequest(dealership));
                }
                case 8 -> {
                    processAddVehicleRequest(scanner, dealership);
                }
                case 9 -> {
                    processRemoveVehicleRequest(scanner, dealership);
                }
                case 10 -> {
                    System.out.println("Exiting...");
                    running = false;
                    System.exit(0);
                }
            }
        } while (running);
    }

    public List<Vehicle> getByPriceRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles;
        System.out.println("Please enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.println("Please enter maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();
        vehicles = dealership.getVehiclesByPrice(min, max);
        return vehicles;
    }

    public List<Vehicle> getByMakeModelRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles;
        System.out.println("Please enter the make: ");
        String make = scanner.nextLine().trim().toLowerCase();
        System.out.println("Please enter model: ");
        String model = scanner.nextLine().trim().toLowerCase();
        vehicles = dealership.getVehiclesByMakeModel(make, model);
        return vehicles;
    }

    public List<Vehicle> processGetByYearRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles;
        System.out.println("Please enter earlier year for range: ");
        int minYear = scanner.nextInt();
        System.out.println("Please enter later year for range: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        return vehicles;
    }

    public List<Vehicle> getByColorRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles = new ArrayList<>();
        System.out.println("Please enter color: ");
        String color = scanner.nextLine().toLowerCase().trim();
        vehicles = dealership.getVehiclesByColor(color);
        return vehicles;
    }

    public List<Vehicle> processGetByMileageRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles;
        System.out.println("Please enter lower mileage limit: ");
        int minMileage = scanner.nextInt();
        System.out.println("Please enter upper mileage limit: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();
        vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        return vehicles;
    }

    public List<Vehicle> processGetByVehicleTypeRequest(Scanner scanner, Dealership dealership) {
        List<Vehicle> vehicles = new ArrayList<>();
        System.out.println("Please enter a vehicle type (SUV, car, truck, etc): ");
        String vehicleType = scanner.next().trim().toLowerCase();
        vehicles = dealership.getVehiclesByType(vehicleType);
        return vehicles;
    }


    public List<Vehicle> processGetAllVehiclesRequest(Dealership dealership) {
        List<Vehicle> vehicles;
        vehicles = dealership.getAllVehicles();
        return vehicles;
    }

    public void processAddVehicleRequest(Scanner scanner, Dealership dealership) {
        System.out.print("Enter vin: ");
        int vin = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter make: ");
        String make = scanner.next().trim();
        System.out.print("Enter model: ");
        String model = scanner.next().trim();
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.next().trim();
        System.out.print("Enter color: ");
        String color = scanner.next().trim();
        System.out.print("Enter mileage: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        dealership.addVehicle(vin, year, make, model, vehicleType, color, odometer, price);
//        DealershipFileManager fileManager = new DealershipFileManager();
        dealershipCSVManager.saveDealership(dealership);
        System.out.println("Dealership data saved successfully.");
    }

    public void processRemoveVehicleRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        dealership.removeVehicle(vin);
//        DealershipFileManager fileManager = new DealershipFileManager();
        dealershipCSVManager.saveDealership(dealership);
        System.out.println("Dealership data saved successfully.");
    }
}
