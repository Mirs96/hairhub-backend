package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.entities.Appointment;
import org.generation.italy.hairhub.model.entities.Barber;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentDto {
    private long id;
    private String userName;
    private long userId;
    private long barberId;
    private String barberName;
    private long treatmentId;
    private String treatmentName;
    private String date;
    private String startTime;
    private String endTime;
    private String status;

    public AppointmentDto(){}
    public AppointmentDto(long id, String userName, long userId, long barberId, String barberName, long treatmentId, String treatmentName, String date, String startTime, String endTime, String status) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.barberId = barberId;
        this.barberName = barberName;
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Appointment toAppointment() { //restituisce un appointment da un dto
        Appointment appointment = new Appointment();
        appointment.setId(this.id);
        appointment.setDate(LocalDate.parse(this.date));
        appointment.setStartTime(LocalTime.parse(this.startTime));
        appointment.setEndTime(LocalTime.parse(this.endTime));
        appointment.setStatus(this.status);
        return appointment;
    }
    public static AppointmentDto fromAppointment(Appointment app) { //restituire appdto da appointment dato in input
        return new AppointmentDto(app.getId(), app.getUser().getNickname(), app.getUser().getId(), app.getBarber().getId(),
                String.format("%s %s", app.getBarber().getFirstname(), app.getBarber().getLastname()),
                app.getTreatment().getId(), app.getTreatment().getName(),
                app.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                app.getStartTime().format(DateTimeFormatter.ISO_LOCAL_TIME),
                app.getEndTime().format(DateTimeFormatter.ISO_LOCAL_TIME),
                app.getStatus());
    }

    public long getId() {
        return id;
    }

    public long getBarberId() {
        return barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public long getTreatmentId() {
        return treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBarberId(long barberId) {
        this.barberId = barberId;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public void setTreatmentId(long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}