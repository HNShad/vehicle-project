package com.hens.practise.vehicle.dataservice.repository;

import com.hens.practise.vehicle.dataservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
