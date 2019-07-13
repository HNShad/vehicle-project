package com.hens.practise.vehicle.dataservice.repository;

import com.hens.practise.vehicle.dataservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllVehiclesByCustomer(String customer);
    List<Vehicle> findAllVehiclesByStatus(String status);
}
