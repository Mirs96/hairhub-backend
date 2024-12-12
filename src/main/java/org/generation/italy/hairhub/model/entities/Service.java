package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToMany(mappedBy = "services")
    private Set<Salon> salons;

    @OneToMany(mappedBy = "service")
    private Set<Appointment> appointments;

    // Getters and Setters
}