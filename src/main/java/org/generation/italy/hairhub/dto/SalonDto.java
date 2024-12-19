package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Salon;

import java.util.List;

public class SalonDto {
    private long id;
    private String name;
    private String address;

    public SalonDto(){}

    public SalonDto(String name, long id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public SalonDto (Salon s){
        this.id = s.getId();
        this.name = s.getName();
        this.address = s.getAddress();
    }

    public static List<SalonDto> fromSalons(List<Salon> salons){
        return salons.stream().map(SalonDto::new).toList();
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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
