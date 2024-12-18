package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Salon;

public class SalonDto {
    private long id;
    private String name;

    public SalonDto(){}

    public SalonDto(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public SalonDto (Salon s){
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
