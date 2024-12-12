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

    private String firstname;

    private String lastname;

    private String dob; // You can use LocalDate instead if needed

    private String sex;

    @Column(unique = true)
    private String mail;

    private String password;

    private String phone;


    // Getters and Setters
}