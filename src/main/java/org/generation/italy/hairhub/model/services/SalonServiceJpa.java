package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.entities.Treatment;
import org.generation.italy.hairhub.model.repositories.SalonRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalonServiceJpa implements SalonService {
    SalonRepositoryJpa salonRepo;
    @Autowired
    public SalonServiceJpa(SalonRepositoryJpa salonRepo) {
        this.salonRepo = salonRepo;
    }
    @Override
    public List<Salon> getTopSalons(Integer type) {
        List<Salon> topSalons = salonRepo.getSalonsByOptionalServiceType(type);
        return topSalons;
    }
}
