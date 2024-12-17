package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.SalonDto;
import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonController {
    private SalonService salonService;
    @Autowired
    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }
    @GetMapping
    public ResponseEntity<List<SalonDto>> getTop5Salons(){
        List<Salon> salons = salonService.getTopSalons();
        List<SalonDto> salonDtos = salons.stream().map(SalonDto::new).toList();
        return ResponseEntity.ok(salonDtos);
    }
    @GetMapping("/{type}")
    public ResponseEntity<List<SalonDto>> getTop5SalonsForByServiceType(@PathVariable int type) {
        List<Salon> salons = salonService.getTopSalonsByServiceType(type);
        List<SalonDto> salonDtos = salons.stream().map(SalonDto::new).toList();
        return ResponseEntity.ok(salonDtos);
    }
}
