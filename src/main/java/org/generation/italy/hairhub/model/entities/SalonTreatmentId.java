package org.generation.italy.hairhub.model.entities;

import java.io.Serializable;
import java.util.Objects;


public class SalonTreatmentId implements Serializable {
    private Long salon;
    private Long treatment;

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

    public Long getSalon() {
        return salon;
    }

    public void setSalon(Long salon) {
        this.salon = salon;
    }

    public Long getTreatment() {
        return treatment;
    }

    public void setTreatment(Long treatment) {
        this.treatment = treatment;
    }
}