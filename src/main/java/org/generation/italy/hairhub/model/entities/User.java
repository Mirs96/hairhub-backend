package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dob")
    private String dob; // You can use LocalDate instead if needed

    @Column(name = "sex")
    private String sex;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "pass")
    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Appointment> appointments;

    // Getters and Setters
}