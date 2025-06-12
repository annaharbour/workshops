package com.pluralsight.dealership.ui;

import com.pluralsight.dealership.dao.ContractFileManager;
import com.pluralsight.dealership.dao.DataManager;
import com.pluralsight.dealership.dao.DealershipFileManager;
import com.pluralsight.dealership.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //        TODO handle incorrect input ie year not 4 digits
//    TODO Admin LIST ALL CONTRACTS || LIST LAST 10 CONTRACTS
//    TODO: Choose dealership / multiple dealerships
//    TODO: Return ArrayList<Contract> and ArrayList<Dealership>
    private Dealership dealership;
    //    private DealershipFileManager dealershipManager;
    private DataManager<Dealership> dealershipManager;
    private DataManager<Contract> contractManager;

    public UserInterface() {
        this.dealershipManager = new DealershipFileManager();
        this.dealership = init();

        this.contractManager = new ContractFileManager();
    }

    private Dealership init() {
        dealership = dealershipManager.load();
        return dealership;
    }

    public void displayMenu() {
        String[] menuOptions = {"1) Find vehicles within price range", "2) Find vehicles by make / model", "3) Find " +
                "vehicles by year range", "4) Find vehicles by color", "5) Find vehicles by mileage range", "6) Find " +
                "vehicles " +
                "by type (truck, SUV, van, car)", "7) Get all vehicles", "8) Add a vehicle", "9) Remove a vehicle",
                "10) " +
                        "Lease or Buy a Vehicle " +
                        "contract", "0) Quit"};
        System.out.println("Please select from the following menu options: ");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println("\t" + menuOptions[i]);
        }
    }

    public void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        ;
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
                    addContract(scanner, dealership);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    running = false;
                    System.exit(0);
                }
                default -> {
                    System.out.println("Incorrect option");
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
        dealershipManager.save(dealership);
        System.out.println("Dealership data saved successfully.");
    }

    public void processRemoveVehicleRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        dealership.removeVehicle(vin);
        dealershipManager.save(dealership);
        System.out.println("Dealership data saved successfully.");
    }

    public void addContract(Scanner scanner, Dealership dealership) {
        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter your email: ");
        String customerEmail = scanner.nextLine();
        boolean isValid = customerEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        if (!isValid) {
            throw new IllegalStateException("Invalid email");
        }
        ;
        System.out.println("Enter vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        Vehicle vehicle = dealership.getVehicleByVin(vin);
        System.out.println("Would you like to lease or buy outright? Type lease or buy: ");
        String leaseOrBuy = scanner.nextLine();
        if (leaseOrBuy.equalsIgnoreCase("LEASE")) {
            LeaseContract leaseContract = new LeaseContract(LocalDate.now(), customerName, customerEmail, vehicle);
            System.out.println(leaseContract);
            contractManager.save(leaseContract);
        } else if (leaseOrBuy.equalsIgnoreCase("BUY")) {
            System.out.println("Would you like to finance? y/n");
            String financed = scanner.nextLine();
            boolean isFinanced = false;
            if (financed.equalsIgnoreCase("y")) isFinanced = true;
            SalesContract salesContract = new SalesContract(LocalDate.now(), customerName, customerEmail, vehicle,
                    isFinanced);
            contractManager.save(salesContract);
            System.out.println(salesContract);
            dealership.removeVehicle(vin);
            dealershipManager.save(dealership);
        } else {
            throw new IllegalStateException("Must choose lease or buy");
        }

    }
}
