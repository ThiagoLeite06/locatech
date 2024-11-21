package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Rental;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RentalRepositoryImpl implements RentalRepository {
    private final JdbcClient jdbcClient;

    public RentalRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT r.id, r.person_id, r.vehicle_id, r.start_date, r.end_date, r.total_value," +
                        "p.name AS person_name, p.cpf AS person_cpf," +
                        "v.model AS vehicle_model, v.plate AS vehicle_plate " +
                        "FROM rentals r" +
                        "INNER JOIN people p ON r.person_id = p.id " +
                        "INNER JOIN vehicles v ON r.vehicle_id = v.id " +
                        "WHERE r.id = :id")
                .param("id", id)
                .query(Rental.class)
                .optional();
    }

    @Override
    public List<Rental> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM r.id, r.person_id, r.vehicle_id, r.start_date, r.end_date, r.total_value," +
                    "p.name AS person_name, p.cpf AS person_cpf," +
                    "v.model AS vehicle_model, v.plate AS vehicle_plate " +
                    "FROM rentals r" +
                    "INNER JOIN people p ON r.person_id = p.id " +
                    "INNER JOIN vehicles v ON r.vehicle_id = v.id " +
                    "LIMIT :size, :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Rental.class)
                .list();

    }

    @Override
    public Integer save(Rental rental) {
        return this.jdbcClient
                .sql("INSERT INTO rentals (person_id, vehicle_id, start_date, end_date, total_value) VALUES (:person_id, :vehicle_id, :start_date, :end_date, :total_value)")
                .param("person_id", rental.getPersonId())
                .param("vehicle_id", rental.getVehicleId())
                .param("start_date", rental.getStartDate())
                .param("end_date", rental.getEndDate())
                .param("total_value", rental.getTotalValue())
                .update();
    }

    @Override
    public Integer update(Rental rental, Long id) {
        return this.jdbcClient
                .sql("UPDATE rentals SET person_id = :person_id, vehicle_id = :vehicle_id, start_date = :start_date, end_date = :end_date, total_value = :total_value WHERE id = :id")
                .param("person_id", rental.getPersonId())
                .param("vehicle_id", rental.getVehicleId())
                .param("start_date", rental.getStartDate())
                .param("end_date", rental.getEndDate())
                .param("total_value", rental.getTotalValue())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM rentals WHERE id = :id")
                .param("id", id)
                .update();
    }
}
