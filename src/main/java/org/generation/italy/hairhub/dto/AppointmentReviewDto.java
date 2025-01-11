package org.generation.italy.hairhub.dto;

import org.generation.italy.hairhub.model.AppointmentReviewInfo;
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

    public static AppointmentReviewDto fromAppointmentWithPrice(AppointmentReviewInfo app) {
        return new AppointmentReviewDto(
                app.getAppointment().getId(),
                app.getAppointment().getUser().getId(),
                app.getAppointment().getBarber().getId(),
                app.getAppointment().getBarber().getFirstname() + " " + app.getAppointment().getBarber().getLastname(),
                app.getAppointment().getUser().getNickname(),
                app.getAppointment().getDate().toString(), // Convert LocalDate to String
                app.getAppointment().getStartTime().toString(), // Convert LocalTime to String
                app.getAppointment().getEndTime().toString(), // Convert LocalTime to String
                app.getAppointment().getStatus(),
                app.isCanReview(),
                app.getAppointment().getTreatments().stream().map(TreatmentDto::new).toList()
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
