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

    // Getters and Setters
}