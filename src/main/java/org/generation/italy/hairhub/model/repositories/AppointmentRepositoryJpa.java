package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepositoryJpa extends JpaRepository <Appointment, Long> {
List<Appointment> findByBarberAndDateRange(long barberId, LocalDate today, LocalDate endDate);
List<Appointment> findByBarberAndDate(long barberId, LocalDate date);


}
