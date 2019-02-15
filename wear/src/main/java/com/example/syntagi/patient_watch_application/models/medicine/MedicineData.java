package com.example.syntagi.patient_watch_application.models.medicine;

import java.io.Serializable;
import java.util.List;

public class MedicineData implements Serializable {
    public String dose;
    private String medicineId;
    private String medicineName;
    private String doseType;
    private List<ConstituentData> constituents;
    private List<MedicineFrequency> frequencies;

    private boolean isOpen;
    private String vaccineId;
    private Integer painType;
    private String expDateString;
    private String pkgDateString;
    private String pharmacyStockId;
    private String batchNumber;
    private String imageUrl;


    //not related from api
    private boolean isScheduleVisible;
    private int reminderId;
    private boolean disableSwitch;
    private int doseTypeView;

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

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

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public List<ConstituentData> getConstituents() {
        return constituents;
    }

    public void setConstituents(List<ConstituentData> constituents) {
        this.constituents = constituents;
    }

    public List<MedicineFrequency> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(List<MedicineFrequency> frequencies) {
        this.frequencies = frequencies;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Integer getPainType() {
        return painType;
    }

    public void setPainType(Integer painType) {
        this.painType = painType;
    }

    public String getExpDateString() {
        return expDateString;
    }

    public void setExpDateString(String expDateString) {
        this.expDateString = expDateString;
    }

    public String getPkgDateString() {
        return pkgDateString;
    }

    public void setPkgDateString(String pkgDateString) {
        this.pkgDateString = pkgDateString;
    }

    public String getPharmacyStockId() {
        return pharmacyStockId;
    }

    public void setPharmacyStockId(String pharmacyStockId) {
        this.pharmacyStockId = pharmacyStockId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isScheduleVisible() {
        return isScheduleVisible;
    }

    public void setScheduleVisible(boolean scheduleVisible) {
        isScheduleVisible = scheduleVisible;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public boolean isDisableSwitch() {
        return disableSwitch;
    }

    public void setDisableSwitch(boolean disableSwitch) {
        this.disableSwitch = disableSwitch;
    }

    public int getDoseTypeView() {
        return doseTypeView;
    }

    public void setDoseTypeView(int doseTypeView) {
        this.doseTypeView = doseTypeView;
    }
}