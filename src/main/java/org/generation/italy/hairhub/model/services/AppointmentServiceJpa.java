package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.repositories.AppointmentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class AppointmentServiceJpa implements AppointmentService {
    private AppointmentRepositoryJpa appRepo;

    @Autowired
    public AppointmentServiceJpa(AppointmentRepositoryJpa appRepo) {
        this.appRepo = appRepo;
    }

    @Override
    public Optional<Appointment> update(long id) {
        Optional<Appointment> oa = appRepo.findById(id);
//        if (oa.isPresent()) {
//            Appointment appointment = oa.get();
//            Period period = Period.between(appointment.getDate(), LocalDate.now()); //prende il lasso di tempo tra l'ora dell'appuntamento e l'ora di adesso
//            if (period.getDays() > 1) { //period.getDays() diventa un numero, ovvero i giorni che mancano tra oggi e il giorno dellappuntamento
//                Appointment updateAppointment = appRepo.save(appointment);
//                return Optional.of(updateAppointment);
//            }
        if (oa.isPresent()) {
            Appointment appointment = oa.get();
            Appointment updateAppointment = appRepo.save(appointment);
            return Optional.of(updateAppointment);
        }
        return Optional.empty();
    }
}