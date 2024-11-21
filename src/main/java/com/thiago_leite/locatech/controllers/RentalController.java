package com.thiago_leite.locatech.controllers;

import com.thiago_leite.locatech.entities.Rental;
import com.thiago_leite.locatech.services.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<Rental>> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Foi acessado o endpoint de pessoa /rental");
        var person = this.rentalService.findAll(page, size);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rental>> findPerson(
            @PathVariable("id") Long id
    ) {
        logger.info("/person/"+ id);
        var person = this.rentalService.findRentalById(id);
        return ResponseEntity.ok(person);

    }

    @PostMapping
    public ResponseEntity<Void> savePerson(
            @RequestBody Rental rental
    ){
        logger.info("POST -> /person");
        this.rentalService.saveRental(rental);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(
            @PathVariable("id") Long id,
            @RequestBody Rental rental
    ){
        logger.info("PUT -> /rental/"+ id);
        this.rentalService.updateRental(rental, id);
        var status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status.value()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE -> /rental/"+ id);
        this.rentalService.delete(id);
        return ResponseEntity.ok().build();
    }
}
