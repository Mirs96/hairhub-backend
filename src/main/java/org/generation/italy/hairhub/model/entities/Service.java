package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id")
    private Long id;
    private String name;
    private String description;
    @Column(name = "img_url")
    private String imgUrl;
    private int type; //1 hair, 2 beard, 3 other
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalonService> salonServices;

    public Service(){}
    public Service(Long id, String name, String description, String imgUrl, int type, List<SalonService> salonServices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.type = type;
        this.salonServices = salonServices;
    }
    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getType() {
        return type;
    }

    public List<SalonService> getSalonServices() {
        return salonServices;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSalonServices(List<SalonService> salonServices) {
        this.salonServices = salonServices;
    }
}