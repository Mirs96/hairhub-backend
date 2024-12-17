package org.generation.italy.hairhub.model.servicies;

import org.generation.italy.hairhub.model.entities.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> update(long id);
}
