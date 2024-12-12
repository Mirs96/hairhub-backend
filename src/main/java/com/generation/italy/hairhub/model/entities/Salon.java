package com.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "salons")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sal_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "cap")
    private String cap;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "closing_day")
    private int closingDay;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;

    @OneToMany(mappedBy = "salon")
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "salon")
    private Set<Barber> barbers;

    @ManyToMany
    @JoinTable(
            name = "salon_services",
            joinColumns = @JoinColumn(name = "sal_id"),
            inverseJoinColumns = @JoinColumn(name = "serv_id")
    )
    private Set<Service> services;

    // Getters and Setters
}