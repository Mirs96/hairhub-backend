package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepositoryJpa extends JpaRepository <Appointment, Long> {
}
