package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


public class SalonServiceId implements Serializable {
    private Long salon;
    private Long service;

    // Default constructor, equals, and hashCode
    public SalonServiceId(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalonServiceId that = (SalonServiceId) o;
        return Objects.equals(salon, that.salon) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salon, service);
    }
}