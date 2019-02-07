package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class NAPROZDTABLET {
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("medication")
    @Expose
    private Medication medication;
    @SerializedName("precriptionId")
    @Expose
    private String precriptionId;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getPrecriptionId() {
        return precriptionId;
    }

    public void setPrecriptionId(String precriptionId) {
        this.precriptionId = precriptionId;
    }

}
