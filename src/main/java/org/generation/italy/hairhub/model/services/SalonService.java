package org.generation.italy.hairhub.model.services;
import org.generation.italy.hairhub.model.entities.Salon;

import java.util.List;
import java.util.Optional;

public interface SalonService {
    List<Salon> getTopSalons(Integer type, int num);
    List<Salon> getSalonsByNameOrAddress(String name);
    Optional<Salon> getSalonById(long id);
    List<Salon> getSalonsByTreatmentId(long treatmentId);
}
