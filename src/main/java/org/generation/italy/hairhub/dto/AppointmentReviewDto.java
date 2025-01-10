package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.AppointmentWithPrices;

import java.util.List;

public class AppointmentReviewDto {
    private long id;
    private String userName;
    private long userId;
    private long barberId;
    private String barberName;
    private String date;
    private String startTime;
    private String endTime;
    private String status;
    private boolean canReview;
    private List<TreatmentDto> treatments;


    public AppointmentReviewDto(){}
    public AppointmentReviewDto(long id, long userId, long barberId,String userName, String barberName, String date, String startTime, String endTime, String status,boolean canReview,List<TreatmentDto> treatments) {
        this.id = id;
        this.userId = userId;
        this.barberId = barberId;
        this.userName = userName;
        this.barberName = barberName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.canReview = canReview;
        this.treatments = treatments;
    }

    public static AppointmentReviewDto fromAppointmentWithPrice(AppointmentWithPrices appointment, boolean canReview) {
        return new AppointmentReviewDto(
                appointment.getId(),
                appointment.getUser().getId(),
                appointment.getBarber().getId(),
                appointment.getBarber().getFirstname() + " " + appointment.getBarber().getLastname(),
                appointment.getUser().getNickname(),
                appointment.getDate().toString(), // Convert LocalDate to String
                appointment.getStartTime().toString(), // Convert LocalTime to String
                appointment.getEndTime().toString(), // Convert LocalTime to String
                appointment.getStatus(),
                canReview,
                appointment.getTreatments().stream().map(TreatmentDto::new).toList()
        );
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getBarberId() {
        return barberId;
    }

    public void setBarberId(long barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isCanReview() {
        return canReview;
    }

    public void setCanReview(boolean canReview) {
        this.canReview = canReview;
    }

    public List<TreatmentDto> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<TreatmentDto> treatments) {
        this.treatments = treatments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
