package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Check(constraints = "rating between 0 and 5")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Appointment appointment;

    private LocalDate date;

    private int rating;

    private String comment;

    // Getters and Setters

    public Review(){}

    public Review(long id, Appointment appointment, LocalDate date, int rating, String comment) {
        this.id = id;
        this.appointment = appointment;
        this.date = date;
        this.rating = rating;
        this.comment = comment;
    }

    public long getId() {
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

    public void setId(long id) {
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