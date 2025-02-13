package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.*;
import org.generation.italy.hairhub.model.AppointmentReviewInfo;
import org.generation.italy.hairhub.model.AppointmentWithPrices;
import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.exceptions.EntityNotFoundException;
import org.generation.italy.hairhub.model.services.AppointmentService;
import org.generation.italy.hairhub.model.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController

@RequestMapping("/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    private ReviewService reviewService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService, ReviewService reviewService) {
        this.appointmentService = appointmentService;
        this.reviewService = reviewService;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable long id) {
        Optional<Appointment> oa = appointmentService.update(id);
        if (oa.isPresent()) {
            return ResponseEntity.noContent().build(); //noContent significa che è andato tutto bene ma non c'è nulla da mandare(codice 204)
        }
        return ResponseEntity.notFound().build(); //notFound è quando proprio non trova nulla
    }
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentDto appDto, UriComponentsBuilder uriBuilder) {
        Appointment app = appDto.toAppointment();
        try {
            List<Long> treatmentsId = appDto.getTreatments();
            AppointmentWithPrices appPrice = appointmentService.create(app, appDto.getBarberId(), treatmentsId, appDto.getUserId());
            URI location = uriBuilder.path("/appointment/{id}").buildAndExpand(app.getId()).toUri();
            return ResponseEntity.created(location).body(AppointmentDto.fromAppointmentWithPrice(appPrice));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getFullMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{barberId}/available-dates")
    public ResponseEntity<?> getAvailableDatesForBarber(@PathVariable long barberId,@RequestParam (required = false) Integer bookingMonths,@RequestParam Integer numberOfTreatments){
        int month = bookingMonths!=null && bookingMonths>0 && bookingMonths < 3 ? bookingMonths : 1;
        try {
            List<LocalDate> availableDates = appointmentService.getAvailableDatesForBarber(barberId,month,numberOfTreatments);
            List<String> dateStrings = availableDates.stream()
                    .map(date -> date.format(DateTimeFormatter.ISO_DATE)).toList();
            return ResponseEntity.ok(new AvailableDatesDto(dateStrings));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getFullMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{barberId}/available-times")
    public ResponseEntity<?> getAvailableTimesForBarber(@PathVariable long barberId, @RequestParam String date,@RequestParam Integer numberOfTreatments) {
        try {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            List<LocalTime> availableTimes = appointmentService.getAvailableTimesForBarber(barberId, parsedDate,numberOfTreatments);
            List<String> timeStrings = availableTimes.stream()
                    .map(time -> time.format(DateTimeFormatter.ofPattern("HH:mm"))).toList();
            return ResponseEntity.ok(new AvailableTimesDto(timeStrings));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getFullMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/future/{userId}")
    public ResponseEntity<List<AppointmentPriceDto>> getFutureAppointmentsByUserId(@PathVariable long userId) {
        List<AppointmentWithPrices> appointmentsP = appointmentService.getFutureAppointmentsByUserId(userId);
        List<AppointmentPriceDto> appointmentPriceDtos = appointmentsP.stream().map(AppointmentPriceDto::fromAppointmentWithPrice).toList();
        return ResponseEntity.ok(appointmentPriceDtos);
    }

    @GetMapping("/past/{userId}")
    public ResponseEntity<?> getPastAppointmentsByUserId(@PathVariable long userId) {
        List<AppointmentReviewInfo> appointmentsR = appointmentService.getPastAppointmentsByUserId(userId);
        List<AppointmentReviewDto> appointmentDtos = new ArrayList<>();

        for (AppointmentReviewInfo a : appointmentsR) {
            AppointmentReviewDto dto = AppointmentReviewDto.fromAppointmentWithPrice(a);
            appointmentDtos.add(dto);
        }

        return ResponseEntity.ok(appointmentDtos);
    }

}
