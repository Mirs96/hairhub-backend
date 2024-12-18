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
    private long id;

    private String firstname;

    private String lastname;
    private String nickname;

    private LocalDate dob; // You can use LocalDate instead if needed

    private String sex;

    @Column(unique = true)
    private String mail;

    private String pass;

    private String phone;


    // Getters and Setters

    public User(){}

    public User(long id, String firstname, String lastname, String nickname, LocalDate dob, String sex, String mail, String pass, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.dob = dob;
        this.sex = sex;
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public LocalDate getDob() {
        return dob;
    }
    public String getSex() {
        return sex;
    }
    public String getMail() {
        return mail;
    }
    public String getPass() {
        return pass;
    }
    public String getPhone() {
        return phone;
    }
    public String getNickname() {
        return nickname;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}