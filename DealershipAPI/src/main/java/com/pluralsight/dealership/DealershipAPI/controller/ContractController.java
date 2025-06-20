package com.pluralsight.dealership.DealershipAPI.controller;
import com.pluralsight.dealership.DealershipAPI.dao.ContractDao;
import com.pluralsight.dealership.DealershipAPI.model.Lease;
import com.pluralsight.dealership.DealershipAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private ContractDao dao;

    @Autowired
    public ContractController(ContractDao dao) {
        this.dao = dao;
    }

    @GetMapping("/leases")
    public List<Lease> getAllLeases() {
        return dao.getAllLeases();
    }

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return dao.getAllSales();
    }


    @GetMapping("/leases/{id}")
    public Lease getLease(@PathVariable int id) {
        return dao.getLease(id);
    }

    @GetMapping("/sales/{id}")
    public Sale getSale(@PathVariable int id) {
        return dao.getSale(id);
    }


    @PostMapping("/leases")
    @ResponseStatus(HttpStatus.CREATED)
    public Lease addLease(@RequestBody Lease lease) {
        return dao.addLease(lease);
    }

    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public Sale addSaleContract(@RequestBody Sale sale) {
        return dao.addSale(sale);
    }

    @PutMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lease updateSale(@RequestParam int id, @RequestBody Lease lease) {
        return dao.updateSale(id, lease);
    }

    @PutMapping("/leases/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lease updateLease(@RequestParam int id, @RequestBody Sale sale) {
        return dao.updateLease(id, sale);
    }

    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(int id) {
        dao.deleteSale(id);
    }
    @DeleteMapping("/leases/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLease(int id) {
        dao.deleteLease(id);
    }
}
