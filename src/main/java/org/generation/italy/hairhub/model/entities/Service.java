package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id")
    private Long id;

    private String name;

    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalonService> salonServices;

    // Getters and Setters
}