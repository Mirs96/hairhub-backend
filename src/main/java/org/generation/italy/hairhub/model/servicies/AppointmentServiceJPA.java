package org.generation.italy.hairhub.model.servicies;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.repositories.AppointmentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceJPA implements AppointmentService{
    private AppointmentRepositoryJPA appointmentRepo;

    @Autowired
    public AppointmentServiceJPA(AppointmentRepositoryJPA appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Optional<Appointment> update(long id) { //danilo <3
        Optional<Appointment> oa = appointmentRepo.findById(id);
        if(oa.isPresent()){
            Appointment app = oa.get();
            Appointment updatedApp = appointmentRepo.save(app);
            return Optional.of(updatedApp);
        }
        return Optional.empty();
    }
}
