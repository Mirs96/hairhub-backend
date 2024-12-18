package org.generation.italy.hairhub.model.services;
import org.generation.italy.hairhub.model.TreatmentWithPrice;
import java.util.List;

public interface TreatmentService {
    List<TreatmentWithPrice> getTreatmentBySalon(long salonId);
}
