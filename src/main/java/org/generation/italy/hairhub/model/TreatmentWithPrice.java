package org.generation.italy.hairhub.model;

import org.generation.italy.hairhub.model.entities.Treatment;

import java.math.BigDecimal;

public class TreatmentWithPrice {
    private Treatment treatment;
    private BigDecimal price;

    public TreatmentWithPrice(){}
    public TreatmentWithPrice(Treatment treatment, BigDecimal price) {
        this.treatment = treatment;
        this.price = price;
    }

    public Treatment getTreatment() {
        return treatment;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
