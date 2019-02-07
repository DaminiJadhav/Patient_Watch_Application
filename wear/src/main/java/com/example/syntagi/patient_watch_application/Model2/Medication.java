package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

class Medication {
    @SerializedName("medicineId")
    @Expose
    private String medicineId;
    @SerializedName("medicineName")
    @Expose
    private String medicineName;
    @SerializedName("constituents")
    @Expose
    private List<Constituent> constituents = null;
    @SerializedName("dose")
    @Expose
    private String dose;
    @SerializedName("doseType")
    @Expose
    private String doseType;
    @SerializedName("frequencies")
    @Expose
    private List<Frequency> frequencies = null;
    @SerializedName("painType")
    @Expose
    private Integer painType;
    @SerializedName("totalFrequency")
    @Expose
    private Integer totalFrequency;
    @SerializedName("frequencyLength")
    @Expose
    private Integer frequencyLength;
    @SerializedName("constituentsString")
    @Expose
    private String constituentsString;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public List<Constituent> getConstituents() {
        return constituents;
    }

    public void setConstituents(List<Constituent> constituents) {
        this.constituents = constituents;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public List<Frequency> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(List<Frequency> frequencies) {
        this.frequencies = frequencies;
    }

    public Integer getPainType() {
        return painType;
    }

    public void setPainType(Integer painType) {
        this.painType = painType;
    }

    public Integer getTotalFrequency() {
        return totalFrequency;
    }

    public void setTotalFrequency(Integer totalFrequency) {
        this.totalFrequency = totalFrequency;
    }

    public Integer getFrequencyLength() {
        return frequencyLength;
    }

    public void setFrequencyLength(Integer frequencyLength) {
        this.frequencyLength = frequencyLength;
    }

    public String getConstituentsString() {
        return constituentsString;
    }

    public void setConstituentsString(String constituentsString) {
        this.constituentsString = constituentsString;
    }

}
