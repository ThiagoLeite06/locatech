package com.thiago_leite.locatech.controllers;

import com.thiago_leite.locatech.entities.Person;
import com.thiago_leite.locatech.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Foi acessado o endpoint de pessoa /person");
        var person = this.personService.findAll(page, size);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findPerson(
            @PathVariable("id") Long id
    ) {
        logger.info("/person/"+ id);
        var person = this.personService.findPersonById(id);
        return ResponseEntity.ok(person);

    }

    @PostMapping
    public ResponseEntity<Void> savePerson(
            @RequestBody Person person
    ){
        logger.info("POST -> /person");
        this.personService.savePerson(person);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(
            @PathVariable("id") Long id,
            @RequestBody Person person
    ){
        logger.info("PUT -> /person/"+ id);
        this.personService.updatePerson(person, id);
        var status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status.value()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE -> /vehicles/"+ id);
        this.personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
