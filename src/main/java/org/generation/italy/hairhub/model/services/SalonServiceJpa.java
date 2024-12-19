package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.entities.Treatment;
import org.generation.italy.hairhub.model.repositories.SalonRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceJpa implements SalonService {
    SalonRepositoryJpa salonRepo;
    @Autowired
    public SalonServiceJpa(SalonRepositoryJpa salonRepo) {
        this.salonRepo = salonRepo;
    }
    @Override
    public List<Salon> getTopSalons(Integer type, int num) {
        return  salonRepo.getSalonsByOptionalServiceType(type,num);
    }

    @Override
    public List<Salon> getSalonsByNameOrAddress(String name) {
        List<Salon> salons = salonRepo.searchByNameOrAddress(name);
        return  salons;
    }

    @Override
    public Optional<Salon> getSalonById(long id) {
        return salonRepo.findById(id);
    }

    @Override
    public List<Salon> getSalonsByTreatmentId(long treatmentId) {
        return salonRepo.findByTreatmentId(treatmentId);
    }
}
