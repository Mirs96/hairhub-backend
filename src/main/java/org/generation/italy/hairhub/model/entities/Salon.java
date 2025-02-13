package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salons")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sal_id")
    private long id;

    private String name;

    private String city;

    private String cap;

    private String address;

    private String phone;

    @Column(name = "closing_day")
    private int closingDay;

    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Column(name = "closing_time")
    private LocalTime closingTime;

    @OneToMany(mappedBy = "salon")
    private Set<Barber> barbers; //qui viene usato un set, valutare se cambiarlo in lista per semplificare o lasciare così

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalonTreatment> treatments;
    // Getters and Setters


    public Salon(){}

    public Salon(long id, String name, String city, String cap, String address, String phone, int closingDay, LocalTime openingTime, LocalTime closingTime, Set<Barber> barbers, List<SalonTreatment> salonTreatments) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.cap = cap;
        this.address = address;
        this.phone = phone;
        this.closingDay = closingDay;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.barbers = barbers;
        this.treatments = salonTreatments;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getCap() {
        return cap;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public int getClosingDay() {
        return closingDay;
    }
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    public LocalTime getClosingTime() {
        return closingTime;
    }
    public Set<Barber> getBarbers() {
        return barbers;
    }
    public List<SalonTreatment> getTreatments() {
        return treatments;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCap(String cap) {
        this.cap = cap;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setClosingDay(int closingDay) {
        this.closingDay = closingDay;
    }
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public void setBarbers(Set<Barber> barbers) {
        this.barbers = barbers;
    }
    public void setTreatments(List<SalonTreatment> treatments) {
        this.treatments = treatments;
    }
}