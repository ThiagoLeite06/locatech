package com.thiago_leite.locatech.services;

import com.thiago_leite.locatech.entities.Rental;
import com.thiago_leite.locatech.repositories.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    public List<Rental> findAll(int page, int size) {
        int offset = (page - 1) * size;
        return this.rentalRepository.findAll(size, offset);
    }

    public Optional<Rental> findRentalById(Long id) {
        return this.rentalRepository.findById(id);
    }

    public void saveRental(Rental rental) {
        var save = this.rentalRepository.save(rental);
        Assert.state(save == 1, "Erro ao salvar locação " + rental.getPersonId());
    }

    public void updateRental(Rental rental, Long id) {
        var update = this.rentalRepository.update(rental, id);
        if(update == 0) {
            throw new RuntimeException("Locação não encontrada");
        }
    }

    public void delete(Long id) {
        var delete = this.rentalRepository.delete(id);
        if(delete == 0) {
            throw new RuntimeException("Locação não encontrada");
        }
    }

}
