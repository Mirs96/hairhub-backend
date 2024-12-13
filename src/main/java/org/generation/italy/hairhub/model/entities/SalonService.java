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
}
