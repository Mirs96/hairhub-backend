package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.repositories.SalonRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalonServiceJpa implements SalonService {
    SalonRepositoryJpa salonRepo;
    @Autowired
    public SalonServiceJpa(SalonRepositoryJpa salonRepo) {
        this.salonRepo = salonRepo;
    }
    @Override
    public List<Salon> getTopSalons() {
        List<Salon> allSalons = salonRepo.getSalonsByRating();
        List<Salon> top5Salons = new ArrayList<>(allSalons.subList(0,Math.min(5, allSalons.size())));
        return top5Salons;
    }

    @Override
    public List<Salon> getTopSalonsByServiceType(int type) {
        List<Salon> allSalons = salonRepo.getSalonsByServiceType(type);
        List<Salon> top5Salons = new ArrayList<>(allSalons.subList(0,Math.min(5, allSalons.size())));
        return top5Salons;
    }
}
