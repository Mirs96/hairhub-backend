package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.SalonDto;
import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.servicies.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<SalonDto> dto = salons.stream()
                .map(SalonDto::new).toList();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<SalonDto>> getTopSalonsByServiceType(@PathVariable int type){
        List<Salon> salons = salonService.getTopSalonsByServiceType(type);
        List<SalonDto> dto = salons.stream()
                .map(SalonDto::new).toList();
        return ResponseEntity.ok(dto);
    }
}
