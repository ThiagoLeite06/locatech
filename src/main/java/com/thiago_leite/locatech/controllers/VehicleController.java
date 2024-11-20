package com.thiago_leite.locatech.controllers;

import com.thiago_leite.locatech.entities.Vehicle;
import com.thiago_leite.locatech.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAllVehicles(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        logger.info("Foi acessado o endpoint de veículos /veiculos");
        var vehicles = this.vehicleService.findAllVehicles(page, size);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> findVehicle(
            @PathVariable("id") Long id
    ) {
        logger.info("/vehicles/"+ id);
        var vehicle = this.vehicleService.findVehicleById(id);
        return ResponseEntity.ok(vehicle);

    }

    @PostMapping
    public ResponseEntity<Void> saveVehicle(
            @RequestBody Vehicle vehicle
    ){
        logger.info("POST -> /vehicle");
        this.vehicleService.saveVehicle(vehicle);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehicle(
            @PathVariable("id") Long id,
            @RequestBody Vehicle vehicle
    ){
        logger.info("PUT -> /vehicles/"+ id);
        this.vehicleService.updateVehicle(vehicle, id);
        var status = HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status.value()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE -> /vehicles/"+ id);
        this.vehicleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
