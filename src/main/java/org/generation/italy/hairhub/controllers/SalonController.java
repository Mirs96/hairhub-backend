package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.SalonDto;
import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.services.AppointmentService;
import org.generation.italy.hairhub.model.services.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salon")
public class SalonController {
    private SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping
    public ResponseEntity<List<SalonDto>> getTopSalonsByServiceType(@RequestParam(required = false)Integer type){
        List<Salon> salons = salonService.getTopSalons(type);
        List<SalonDto> dto = salons.stream()
                .map(SalonDto::new).toList();
        return ResponseEntity.ok(dto);
    }
}
