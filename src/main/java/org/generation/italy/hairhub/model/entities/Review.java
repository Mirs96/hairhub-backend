package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Appointment appointment;

    private LocalDate date;
    private int rating;
    private String comment;

    public Review(){}
    public Review(Long id, Appointment appointment, LocalDate date, int rating, String comment) {
        this.id = id;
        this.appointment = appointment;
        this.date = date;
        this.rating = rating;
        this.comment = comment;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}