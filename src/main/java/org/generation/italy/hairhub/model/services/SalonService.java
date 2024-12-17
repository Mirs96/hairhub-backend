package org.generation.italy.hairhub.model.services;
import org.generation.italy.hairhub.model.entities.Salon;
import java.util.List;

public interface SalonService {
    List<Salon> getTopSalons();
    List<Salon> getTopSalonsByServiceType(int type);
}
