package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PatientSuggestion extends BaseApiData{
    private Integer version;
    @SerializedName("suggestedDate")
    @Expose
    private String suggestedDate;
    @SerializedName("suggestedTimeSlots")
    @Expose
    private List<SuggestedTimeSlot> suggestedTimeSlots = null;


    public String getSuggestedDate() {
        return suggestedDate;
    }

    public void setSuggestedDate(String suggestedDate) {
        this.suggestedDate = suggestedDate;
    }

    public List<SuggestedTimeSlot> getSuggestedTimeSlots() {
        return suggestedTimeSlots;
    }

    public void setSuggestedTimeSlots(List<SuggestedTimeSlot> suggestedTimeSlots) {
        this.suggestedTimeSlots = suggestedTimeSlots;
    }

}
