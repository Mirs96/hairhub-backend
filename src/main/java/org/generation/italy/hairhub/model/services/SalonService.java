package org.generation.italy.hairhub.model.services;
import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.entities.Treatment;

import java.util.List;

public interface SalonService {
    List<Salon> getTopSalons(Integer type);
}
