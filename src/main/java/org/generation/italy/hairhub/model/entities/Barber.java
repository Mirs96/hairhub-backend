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

    public Barber(){}

    public Barber(Long id, Salon salon, String firstname, String lastname) {
        this.id = id;
        this.salon = salon;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}