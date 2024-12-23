package com.thiago_leite.locatech.repositories;

import com.thiago_leite.locatech.entities.Person;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final JdbcClient jdbcClient;

    public PersonRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    @Override
    public Optional<Person> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM people WHERE id = :id")
                .param("id", id)
                .query(Person.class)
                .optional();
    }

    @Override
    public List<Person> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM people LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Person.class)
                .list();

    }

    @Override
    public Integer save(Person person) {
        return this.jdbcClient
                .sql("INSERT INTO people (client_name, cpf, phone, email) VALUES (:name, :cpf, :phone, :email)")
                .param("name", person.getName())
                .param("cpf", person.getCpf())
                .param("phone", person.getPhone())
                .param("email", person.getEmail())
                .update();
    }

    @Override
    public Integer update(Person person, Long id) {
        return this.jdbcClient
                .sql("UPDATE people SET client_name = :name, cpf = :cpf, phone = :phone, email = :email WHERE id = :id")
                .param("name", person.getName())
                .param("cpf", person.getCpf())
                .param("phone", person.getPhone())
                .param("email", person.getEmail())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM people WHERE id = :id")
                .param("id", id)
                .update();
    }
}
