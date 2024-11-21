package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    Optional<Rental> findById(Long id);
    List<Rental> findAll(int size, int offset);
    Integer save(Rental person);
    Integer update(Rental person, Long id);
    Integer delete(Long id);
}
