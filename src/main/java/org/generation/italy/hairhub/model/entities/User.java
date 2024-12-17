package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate dob; // You can use LocalDate instead if needed
    private String sex;
    @Column(unique = true)
    private String mail;
    private String pass;
    private String phone;

    public User(){}
    public User(Long id, String firstname, String lastname, LocalDate dob, String sex, String mail, String pass, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.sex = sex;
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
    }
    // Getters and Setters
}