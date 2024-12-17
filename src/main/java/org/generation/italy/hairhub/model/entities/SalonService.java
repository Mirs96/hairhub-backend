package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "salon_services")
@IdClass(SalonServiceId.class)
public class SalonService {
    @Id
    @ManyToOne
    @JoinColumn(name = "sal_id", nullable = false)
    private Salon salon;

    @Id
    @ManyToOne
    @JoinColumn(name = "serv_id", nullable = false)
    private Service service;

    private BigDecimal price;
    public SalonService(){}
    public SalonService(Salon salon, Service service, BigDecimal price) {
        this.salon = salon;
        this.service = service;
        this.price = price;
    }

    public Salon getSalon() {
        return salon;
    }

    public Service getService() {
        return service;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
