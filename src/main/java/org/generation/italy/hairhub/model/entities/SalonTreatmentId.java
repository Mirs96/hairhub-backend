package org.generation.italy.hairhub.model.entities;

import java.io.Serializable;
import java.util.Objects;


public class SalonTreatmentId implements Serializable {
    private long salon;
    private long treatment;

    // Default constructor, equals, and hashCode
    public SalonTreatmentId(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalonTreatmentId that = (SalonTreatmentId) o;
        return Objects.equals(salon, that.salon) && Objects.equals(treatment, that.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salon, treatment);
    }

    public long getSalon() {
        return salon;
    }
    public long getTreatment() {
        return treatment;
    }

    public void setSalon(long salon) {
        this.salon = salon;
    }
    public void setTreatment(long treatment) {
        this.treatment = treatment;
    }
}