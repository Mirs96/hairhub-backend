package com.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barb_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sal_id")
    private Salon salon;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @OneToMany(mappedBy = "barber")
    private Set<Appointment> appointments;

    // Getters and Setters
}