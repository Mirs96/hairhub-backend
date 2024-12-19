package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.BarberDto;
import org.generation.italy.hairhub.model.entities.Barber;
import org.generation.italy.hairhub.model.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barber")
public class BarberController {
    private BarberService barberService;

    @Autowired
    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping("/{salonId}/barbers")
    public ResponseEntity<List<BarberDto>> getBarbersBySalon (@PathVariable long salonId){
        List<Barber> barbers = barberService.getAllBarbersBySalonId(salonId);
        List<BarberDto> dtos = barbers.stream().map(BarberDto :: new).toList();
        return ResponseEntity.ok(dtos);
    }
}
