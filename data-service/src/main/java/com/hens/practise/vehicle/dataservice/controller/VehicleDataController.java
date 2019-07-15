package com.hens.practise.vehicle.dataservice.controller;

import com.hens.practise.vehicle.dataservice.entity.Vehicle;
import com.hens.practise.vehicle.dataservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customers")
    public ResponseEntity<List<Vehicle>> getAllVehiclesByCustomer(@RequestParam("customer") String name) {

        return new ResponseEntity<>(vehicleRepository.findAllVehiclesByCustomer(name), HttpStatus.OK);
    }

    @GetMapping("/statuses")
    public ResponseEntity<List<Vehicle>> getAllVehiclesByStatus(@RequestParam("status") String status) {

        return new ResponseEntity<>(vehicleRepository.findVehiclesByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/customers/all")
    public ResponseEntity<List<String>> getAllCustomers() {

        return new ResponseEntity<>(vehicleRepository.findDistinctCustomer(), HttpStatus.OK);
    }
}
