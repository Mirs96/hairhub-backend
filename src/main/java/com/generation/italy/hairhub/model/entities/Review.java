package com.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private Appointment appointment;

    @Column(name = "date")
    private String date; // You can change it to LocalDate

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    // Getters and Setters
}