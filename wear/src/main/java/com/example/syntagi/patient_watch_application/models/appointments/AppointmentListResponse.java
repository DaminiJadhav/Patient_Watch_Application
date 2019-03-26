package com.example.syntagi.patient_watch_application.models.appointments;

import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppointmentListResponse extends BaseApiResponse {
    @SerializedName("data")
    @Expose
    private List<AppointmentData> data;

    public List<AppointmentData> getData() {
        return data;
    }

    public void setData(List<AppointmentData> data) {
        this.data = data;
    }
}