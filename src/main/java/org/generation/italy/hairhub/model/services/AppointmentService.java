package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.dto.AppointmentDto;
import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.exceptions.EntityNotFoundException;

import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> update(long id);
    Appointment create(Appointment app, long barberId, long treatmentId, long userId) throws EntityNotFoundException;
}
