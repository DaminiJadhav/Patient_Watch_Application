package com.example.syntagi.patient_watch_application.models.appointments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.plumillonforge.android.chipview.Chip;

import java.io.Serializable;

public class TimeSlot implements Serializable, Chip {
    @SerializedName("startTime")
    @Expose
    public String startTime;
    @SerializedName("endTime")
    @Expose
    public String endTime;
    @SerializedName("timeFrequency")
    @Expose
    public Integer timeFrequency;
    @SerializedName("booked")
    @Expose
    private boolean booked;
    @SerializedName("appointmentId")
    @Expose
    private String appointmentId;
    @SerializedName("expired")
    @Expose
    private boolean expired;
    
    @Override
    public String getText() {
        return startTime;
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

    public Integer getTimeFrequency() {
        return timeFrequency;
    }

    public void setTimeFrequency(Integer timeFrequency) {
        this.timeFrequency = timeFrequency;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
