package org.generation.italy.hairhub.model.servicies;

import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.repositories.SalonRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalonServiceJPA implements SalonService {

    SalonRepositoryJPA salonRepo;

    @Autowired
    public SalonServiceJPA(SalonRepositoryJPA salonRepo) {
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
