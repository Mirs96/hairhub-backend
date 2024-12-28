package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.AppointmentWithPrices;
import org.generation.italy.hairhub.model.TreatmentWithPrice;
import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.entities.Barber;
import org.generation.italy.hairhub.model.entities.Treatment;
import org.generation.italy.hairhub.model.entities.User;
import org.generation.italy.hairhub.model.exceptions.EntityNotFoundException;
import org.generation.italy.hairhub.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceJpa implements AppointmentService {
    private AppointmentRepositoryJpa appRepo;
    private BarberRepositoryJpa barberRepo;
    private TreatmentRepositoryJpa treatRepo;
    private UserRepositoryJpa userRepo;
    private SalonTreatmentRepositoryJpa salonTreatRepo;

    @Autowired
    public AppointmentServiceJpa(AppointmentRepositoryJpa appRepo, BarberRepositoryJpa barberRepo, TreatmentRepositoryJpa treatRepo, UserRepositoryJpa userRepo, SalonTreatmentRepositoryJpa salonTreatRepo) {
        this.appRepo = appRepo;
        this.barberRepo = barberRepo;
        this.treatRepo = treatRepo;
        this.userRepo = userRepo;
        this.salonTreatRepo = salonTreatRepo;
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
            appointment.setStatus("Cancelled");
            Appointment updateAppointment = appRepo.save(appointment);
            return Optional.of(updateAppointment);
        }
        return Optional.empty();
    }
    @Override
    public AppointmentWithPrices create(Appointment app, long barberId, List<Long> treatmentsId, long userId) throws EntityNotFoundException{
        Optional<Barber> ob = barberRepo.findById(barberId);//trova tutte le prenotazioni con gli id specificati
        Optional<User> ou = userRepo.findById(userId);
        if (ob.isEmpty() || ou.isEmpty()) {
            throw new EntityNotFoundException("Entità non trovata", ob.isEmpty() ? Barber.class.getSimpleName() : User.class.getSimpleName());
        }
        List<Treatment> treatments = treatRepo.findAllById(treatmentsId);
        if(treatments.size() !=treatmentsId.size()){
            throw new EntityNotFoundException("Treatment non trovati", treatments.getClass().getSimpleName());
        }
        app.setTreatments(treatments);
        app.setBarber(ob.get());
        //.get() va a prendere il contenuto all'interno dell'Optional, perché non posso passare all'entità Appointment un Optional, ma solo il suo contenuto
        app.setUser(ou.get());
        app.setStatus("Confirmed");
        appRepo.save(app); //salva l'appuntamento sul db tramite il repository(il repository è quello che comunica col db)

        List<TreatmentWithPrice> treatmentsWithPrice = new ArrayList<>();
        for (Treatment treatment : treatments) {
            BigDecimal price = salonTreatRepo.getPriceBySalonIdAndTreatmentId(app.getBarber().getSalon().getId(), treatment.getId());
            treatmentsWithPrice.add(new TreatmentWithPrice(treatment, price));
        }

        return new AppointmentWithPrices(
                app.getId(),
                app.getUser().getNickname(),
                app.getUser().getId(),
                app.getBarber().getId(),
                String.format("%s %s", app.getBarber().getFirstname(), app.getBarber().getLastname()),
                app.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                app.getStartTime().format(DateTimeFormatter.ISO_LOCAL_TIME),
                app.getEndTime().format(DateTimeFormatter.ISO_LOCAL_TIME),
                app.getStatus(),
                treatmentsWithPrice
        );


    }
}