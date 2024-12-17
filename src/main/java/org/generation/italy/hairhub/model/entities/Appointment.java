package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "us_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "barb_id", nullable = false)
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "serv_id", nullable = false)
    private Service service;

    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    private String status;

    public Appointment(){};

    public Appointment(Long id, User user, Barber barber, Service service, LocalDate date, LocalTime startTime, LocalTime endTime, String status) {
        this.id = id;
        this.user = user;
        this.barber = barber;
        this.service = service;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Barber getBarber() {
        return barber;
    }

    public Service getService() {
        return service;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}