package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.AppointmentDto;
import org.generation.italy.hairhub.dto.TreatmentDto;
import org.generation.italy.hairhub.model.AppointmentWithPrices;
import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.exceptions.EntityNotFoundException;
import org.generation.italy.hairhub.model.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController

@RequestMapping("/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable long id) {
        Optional<Appointment> oa = appointmentService.update(id);
        if (oa.isPresent()) {
            return ResponseEntity.noContent().build(); //noContent significa che è andato tutto bene ma non c'è nulla da mandare(codice 204)
        }
        return ResponseEntity.notFound().build(); //notFound è quando proprio non trova nulla
    }
    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appDto, UriComponentsBuilder uriBuilder) {
        Appointment app = appDto.toAppointment();
        try {
            List<Long> treatmentsId = appDto.getTreatments().stream().map(TreatmentDto::getId).toList();
            AppointmentWithPrices appPrice = appointmentService.create(app, appDto.getBarberId(), treatmentsId, appDto.getUserId());
            URI location = uriBuilder.path("/appointment/{id}").buildAndExpand(app.getId()).toUri();
            return ResponseEntity.created(location).body(AppointmentDto.fromAppointmentWithPrice(appPrice));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getFullMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
