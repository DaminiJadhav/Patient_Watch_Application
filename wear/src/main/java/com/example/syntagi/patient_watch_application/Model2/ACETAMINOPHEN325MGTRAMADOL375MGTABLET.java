package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ACETAMINOPHEN325MGTRAMADOL375MGTABLET {
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("medication")
    @Expose
    private Medication__ medication;
    @SerializedName("precriptionId")
    @Expose
    private String precriptionId;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Medication__ getMedication() {
        return medication;
    }

    public void setMedication(Medication__ medication) {
        this.medication = medication;
    }

    public String getPrecriptionId() {
        return precriptionId;
    }

    public void setPrecriptionId(String precriptionId) {
        this.precriptionId = precriptionId;
    }


}
