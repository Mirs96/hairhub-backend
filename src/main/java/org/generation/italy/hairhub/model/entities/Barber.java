package org.generation.italy.hairhub.model.entities;

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
    @JoinColumn(name = "sal_id", nullable = false)
    private Salon salon;

    private String firstname;

    private String lastname;

    // Getters and Setters
}