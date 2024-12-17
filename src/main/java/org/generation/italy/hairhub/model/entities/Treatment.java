package org.generation.italy.hairhub.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id")
    private Long id;

    private String name;

    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    private int type; //1 = taglio capelli, 2 = barba

    @OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalonTreatment> salonTreatments;

    // Getters and Setters

    public Treatment(){}

    public Treatment(Long id, String name, String description, String imgUrl, int type, List<SalonTreatment> salonTreatments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.type = type;
        this.salonTreatments = salonTreatments;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<SalonTreatment> getSalonServices() {
        return salonTreatments;
    }

    public void setSalonServices(List<SalonTreatment> salonTreatments) {
        this.salonTreatments = salonTreatments;
    }
}