package com.pluralsight.data;

import com.pluralsight.models.Contract;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager extends FileManager<Contract> {
    private final String delimiter = "|";

    public ContractFileManager() {
        super("CarDealership\\data\\contracts.csv");
    }

    @Override
    public Contract load() {
        Vehicle vehicle = new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 524123, 995.0);
        return new SalesContract(LocalDate.now(), "Dana Wyatt", "dana @texas.com",
                vehicle, false);
    }


    @Override
    public void save(Contract contract) {
        List<String> lines = new ArrayList<>();
        if (contract instanceof SalesContract salesContract) {
            lines.add("SALE" + delimiter + LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                    "yyyyMMdd")) + delimiter + contract.getCustomerName() + delimiter + contract.getCustomerEmail() + delimiter + contract.getVehicleSold().getVin() + delimiter + contract.getVehicleSold().getYear() + contract.getVehicleSold().getMake() + delimiter + contract.getVehicleSold().getModel() + delimiter + contract.getVehicleSold().getVehicleType() + delimiter + contract.getVehicleSold().getColor() + delimiter + contract.getVehicleSold().getOdometer() + delimiter + contract.getOriginalPrice() + delimiter + salesContract.getSalesTaxAmount() + delimiter + salesContract.getRecordingFee() + delimiter + salesContract.getProcessingFee() + delimiter + salesContract.getTotalPrice() + delimiter + (salesContract.isFinanced() ? "YES" : "NO") + delimiter + salesContract.getMonthlyPayment());
        } else if (contract instanceof LeaseContract leaseContract) {
            lines.add("LEASE" + delimiter + LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                    "yyyyMMdd")) + delimiter + contract.getCustomerName() + delimiter + contract.getCustomerEmail() + delimiter + +contract.getVehicleSold().getVin() + delimiter + contract.getVehicleSold().getYear() + contract.getVehicleSold().getMake() + delimiter + contract.getVehicleSold().getModel() + delimiter + contract.getVehicleSold().getVehicleType() + delimiter + contract.getVehicleSold().getColor() + delimiter + contract.getVehicleSold().getOdometer() + delimiter + contract.getOriginalPrice() + delimiter + leaseContract.getLeaseFee() + delimiter + leaseContract.getTotalPrice() + delimiter + leaseContract.getMonthlyPayment());
        } else {
            throw new IllegalStateException("Not a valid contract");
        }

        appendFile(lines, delimiter);
    }

}
