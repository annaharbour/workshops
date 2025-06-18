package com.pluralsight.dealership.DealershipAPI.dao;

import com.pluralsight.dealership.DealershipAPI.model.Contract;
import com.pluralsight.dealership.DealershipAPI.model.Lease;
import com.pluralsight.dealership.DealershipAPI.model.Sale;

import java.util.List;

public interface ContractDao {
    public List<Sale> getAllSales();

    public List<Lease> getAllLeases();

    public Lease updateSale(int id, Lease lease);

    public Lease updateLease(int id, Sale sale);

    public void deleteSale(int id);

    public void deleteLease(int id);

    Sale addSale(Sale sale);

    Lease addLease(Lease lease);

    Lease getLease(int id);

    Sale getSale(int id);
}
