package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.entities.Review;
import org.generation.italy.hairhub.model.exceptions.EntityNotFoundException;
import org.generation.italy.hairhub.model.repositories.AppointmentRepositoryJpa;
import org.generation.italy.hairhub.model.repositories.ReviewRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceJpa implements ReviewService {
    ReviewRepositoryJpa reviewRepository;
    AppointmentRepositoryJpa appRepo;

    @Autowired
    public ReviewServiceJpa(ReviewRepositoryJpa reviewRepository, AppointmentRepositoryJpa appRepo) {
        this.reviewRepository = reviewRepository;
        this.appRepo = appRepo;
    }

    @Override
    public List<Review> getReviewsBySalonId(long salonId) {
        List<Review> reviews = reviewRepository.findReviewsBySalonId(salonId);
        return reviews;
    }

    @Override
    public Review createReview(Review review, long appId) throws EntityNotFoundException {
        Appointment app = appRepo.findById(appId).orElseThrow(() -> new EntityNotFoundException("Entita non trovata", Appointment.class.getName()));

        // Verifica se l'appuntamento è cancellato
        if ("Cancelled".equals(app.getStatus())) {
            throw new IllegalStateException("Non è possibile aggiungere una recensione a un appuntamento cancellato");
        }

        review.setAppointment(app);
        return reviewRepository.save(review);

    }

    @Override
    public Boolean appointmentHasReview(long appointmentId) throws EntityNotFoundException {
        Optional<Appointment> app = appRepo.findById(appointmentId);

        // Verifica se l'appuntamento è presente
        if (app.isEmpty()) {
            throw new EntityNotFoundException("Appointment not found", Appointment.class.getName());
        }

        // Se l'appuntamento è stato cancellato, non è possibile lasciare una recensione
        if (app.get().getStatus().equals("Cancelled")) {
            return false;
        }

        // Verifica se esiste una recensione per questo appuntamento
        Optional<Review> review = reviewRepository.findByAppointmentId(appointmentId);

        // Se esiste una recensione, ritorna true, altrimenti false
        return review.isPresent();
    }
}
