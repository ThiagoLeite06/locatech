package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(Long id);
    List<Person> findAll(int size, int offset);
    Integer save(Person person);
    Integer update(Person person, Long id);
    Integer delete(Long id);
}