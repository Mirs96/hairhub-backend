package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barb_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "sal_id", nullable = false)
    private Salon salon;

    private String firstname;

    private String lastname;

    // Getters and Setters

    public Barber(){}

    public Barber(long id, Salon salon, String firstname, String lastname) {
        this.id = id;
        this.salon = salon;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }
    public Salon getSalon() {
        return salon;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}