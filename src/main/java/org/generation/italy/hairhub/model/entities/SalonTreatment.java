package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
//SISTEMARE IL PREZZO(BIGDECIMAL)
@Entity
@Table(name = "salon_services")
@IdClass(SalonTreatmentId.class)
public class SalonTreatment {
    @Id
    @ManyToOne
    @JoinColumn(name = "sal_id", nullable = false)
    private Salon salon;

    @Id
    @ManyToOne
    @JoinColumn(name = "serv_id", nullable = false)
    private Treatment treatment;

    private BigDecimal price;

    public SalonTreatment(){}

    public SalonTreatment(Salon salon, Treatment treatment, BigDecimal price) {
        this.salon = salon;
        this.treatment = treatment;
        this.price = price;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

