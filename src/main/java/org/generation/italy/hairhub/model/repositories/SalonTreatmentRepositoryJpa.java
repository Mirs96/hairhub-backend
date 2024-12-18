package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.SalonTreatment;
import org.generation.italy.hairhub.model.entities.SalonTreatmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface SalonTreatmentRepositoryJpa extends JpaRepository<SalonTreatment, SalonTreatmentId> {
    public BigDecimal getPriceBySalonIdAndTreatmentId(long salonId, long treatmentId);
}
