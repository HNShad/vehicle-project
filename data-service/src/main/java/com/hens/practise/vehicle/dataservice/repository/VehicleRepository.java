package com.hens.practise.vehicle.dataservice.repository;

import com.hens.practise.vehicle.dataservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllVehiclesByCustomer(String customer);
    List<Vehicle> findVehiclesByStatus(String status);

    @Query("select distinct customer from vehicle")
    List<String> findDistinctCustomer();
}
