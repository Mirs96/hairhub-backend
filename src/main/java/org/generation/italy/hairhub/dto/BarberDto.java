package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Barber;
import org.generation.italy.hairhub.model.entities.Salon;

public class BarberDto {
    private long id;
    private String name;

    public BarberDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BarberDto(){}

    public BarberDto (Barber b){
        this.id = b.getId();
        this.name = String.format("%s %s",b.getFirstname(),b.getLastname());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
