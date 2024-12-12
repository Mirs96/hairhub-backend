package com.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "us_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "barb_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "serv_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "sal_id")
    private Salon salon;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "status")
    private String status;

    // Getters and Setters
}