package com.pluralsight.dealership.DealershipAPI.controller;

import com.pluralsight.dealership.DealershipAPI.dao.VehicleDao;
import com.pluralsight.dealership.DealershipAPI.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleDao dao;

    @GetMapping("")
    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }


    @GetMapping("/price")
    public List<Vehicle> getByPrice(@RequestParam("minPrice") double minPrice,
                                    @RequestParam("maxPrice") double maxPrice) {
        return dao.getByPrice(minPrice, maxPrice);
    }

    @GetMapping("/makemodel")
    public List<Vehicle> getByMakeModel(@RequestParam("make") String make, @RequestParam("model") String model) {
        return dao.getByMakeModel(make, model);
    }

    @GetMapping("/mileage")
    public List<Vehicle> getByMileage(@RequestParam("minMiles") int minMiles,
                                      @RequestParam("maxMiles") int maxMiles) {
        return dao.getByMileage(minMiles, maxMiles);
    }

    @GetMapping("/year")
    public List<Vehicle> getByYear(@RequestParam("minYear") int minYear,
                                   @RequestParam("maxYear") int maxYear) {
        return dao.getByYear(minYear, maxYear);
    }

    @GetMapping("/type")
    public List<Vehicle> getByType(@RequestParam("type") String type) {
        return dao.getByType(type);
    }


    @GetMapping("/color")
    public List<Vehicle> getByColor(@RequestParam("color") String color) {
        return dao.getByColor(color);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return dao.addVehicle(vehicle);
    }

    @PutMapping("/{vin}")
    @ResponseStatus(HttpStatus.OK)
    public Vehicle updateVehicle(@PathVariable("vin") String vin, @RequestBody Vehicle vehicle) {
        return dao.updateVehicle(vin, vehicle);
    }

    @DeleteMapping("/{vin}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable("vin") String vin) {
        dao.deleteVehicle(vin);
    }

}
