package com.example.syntagi.patient_watch_application.models.medicine;
import java.io.Serializable;

public class MedicationEndsOn implements Serializable{
    public String endDate;
    private MedicineData medication;
    private String prescriptionId;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public MedicineData getMedication() {
        return medication;
    }

    public void setMedication(MedicineData medication) {
        this.medication = medication;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


}
