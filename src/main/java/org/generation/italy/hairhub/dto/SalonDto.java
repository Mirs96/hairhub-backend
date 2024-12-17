package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Salon;

public class SalonDto {
    private long id;
    private String name;
    public SalonDto(){};
    public SalonDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public SalonDto(Salon s){
        this.id = s.getId();
        this.name = s.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
