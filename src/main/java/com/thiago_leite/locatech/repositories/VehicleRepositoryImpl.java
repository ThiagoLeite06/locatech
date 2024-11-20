package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Vehicle;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    private final JdbcClient jdbcClient;

    public VehicleRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    @Override
    public Optional<Vehicle> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM vehicles WHERE id = :id")
                .param("id", id)
                .query(Vehicle.class)
                .optional();
    }

    @Override
    public List<Vehicle> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM vehicles LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Vehicle.class)
                .list();

    }

    @Override
    public Integer save(Vehicle vehicle) {
        return this.jdbcClient
                .sql("INSERT INTO vehicles (brand, model, plate, year, color, daily_value) VALUES (:brand, :model, :plate, :year, :color, :daily_value)")
                .param("brand", vehicle.getBrand())
                .param("model", vehicle.getModel())
                .param("plate", vehicle.getPlate())
                .param("year", vehicle.getYear())
                .param("color", vehicle.getColor())
                .param("daily_value", vehicle.getDailyValue())
                .update();
    }

    @Override
    public Integer update(Vehicle vehicle, Long id) {
        return this.jdbcClient
                .sql("UPDATE vehicles SET brand = :brand, model = :model, plate = :plate, year = :year, color = :color, daily_value = :daily_value WHERE id = :id")
                .param("id", id)
                .param("brand", vehicle.getBrand())
                .param("model", vehicle.getModel())
                .param("plate", vehicle.getPlate())
                .param("year", vehicle.getYear())
                .param("color", vehicle.getColor())
                .param("daily_value", vehicle.getDailyValue())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM vehicles WHERE id = :id")
                .param("id", id)
                .update();

    }
}

