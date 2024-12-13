package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salons")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sal_id")
    private Long id;

    private String name;

    private String city;

    private String cap;

    private String address;

    private String phone;

    @Column(name = "closing_day")
    private int closingDay;

    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Column(name = "closing_time")
    private LocalTime closingTime;

    @OneToMany(mappedBy = "salon")
    private Set<Barber> barbers; //qui viene usato un set, valutare se cambiarlo in lista per semplificare o lasciare così

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalonService> salonServices;
    // Getters and Setters
}