package com.hens.practise.vehicle.dataservice.controller;

import com.hens.practise.vehicle.dataservice.entity.Vehicle;
import com.hens.practise.vehicle.dataservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleDataController {

    @Autowired
    private VehicleRepository vehicleRepository;


    @GetMapping("/findall")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {

        return new ResponseEntity(vehicleRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customer}")
    public List<Vehicle> getAllVehiclesByCustomer(@PathVariable("customer") String name) {

        return vehicleRepository.findAllVehiclesByCustomer(name);
    }

    @GetMapping("/status/{status}")
    public List<Vehicle> getAllVehiclesByStatus(@PathVariable("status") String status) {

        return vehicleRepository.findAllVehiclesByStatus(status);
    }
}
