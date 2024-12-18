package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.TreatmentWithPrice;
import org.generation.italy.hairhub.model.entities.Treatment;
import org.generation.italy.hairhub.model.repositories.SalonTreatmentRepositoryJpa;
import org.generation.italy.hairhub.model.repositories.TreatmentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class TreatmentServiceJpa implements TreatmentService{
    TreatmentRepositoryJpa treatRepo;
    SalonTreatmentRepositoryJpa salonTreatRepo;
    @Autowired
    public TreatmentServiceJpa(TreatmentRepositoryJpa treatRepo, SalonTreatmentRepositoryJpa salonTreatRepo) {
        this.treatRepo = treatRepo;
        this.salonTreatRepo = salonTreatRepo;
    }
    @Override
    public List<TreatmentWithPrice> getTreatmentBySalon(long salonId) {
        List<Treatment> allTreatment = treatRepo.findBySalonTreatmentsSalonId(salonId);
        List<TreatmentWithPrice> treatsWPrice = new ArrayList<>();
        for (Treatment treatment : allTreatment) {
            BigDecimal price = salonTreatRepo.getPriceBySalonIdAndTreatmentId(salonId, treatment.getId());
            TreatmentWithPrice treatWPrice = new TreatmentWithPrice(treatment, price);
            treatsWPrice.add(treatWPrice);
        }
        return treatsWPrice;
    }
}
