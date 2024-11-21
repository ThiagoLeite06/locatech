package com.thiago_leite.locatech.services;

import com.thiago_leite.locatech.entities.Person;
import com.thiago_leite.locatech.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(int page, int size) {
        int offset = (page - 1) * size;
        return this.personRepository.findAll(size, offset);
    }

    public Optional<Person> findPersonById(Long id) {
        return this.personRepository.findById(id);
    }

    public void savePerson(Person person) {
        var save = this.personRepository.save(person);
        Assert.state(save == 1, "Erro ao salvar cliente " + person.getName());
    }

    public void updatePerson(Person person, Long id) {
        var update = this.personRepository.update(person, id);
        if(update == 0) {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public void delete(Long id) {
        var delete = this.personRepository.delete(id);
        if(delete == 0) {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}
