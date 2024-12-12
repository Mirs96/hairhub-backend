package org.generation.italy.hairhub.model.entities;

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
    @JoinColumn(name = "us_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "barb_id", nullable = false)
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "serv_id", nullable = false)
    private Service service;

    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    private String status;

    // Getters and Setters
}