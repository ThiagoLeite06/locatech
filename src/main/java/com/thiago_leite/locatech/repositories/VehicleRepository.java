package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findAll(int size, int offset);
    Integer save(Vehicle vehicle);
    Integer update(Vehicle vehicle, Long id);
    Integer delete(Long id);
}
