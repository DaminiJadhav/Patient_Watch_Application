package com.example.syntagi.patient_watch_application.models.appointments;

public class SpecializationData extends BaseApiData{
    private String physiciansSpecializationId;
    private String specialization;
    private String imageUrl;
    private String selectedImageUrl;
    private boolean selected;

    public String getPhysiciansSpecializationId() {
        return physiciansSpecializationId;
    }

    public void setPhysiciansSpecializationId(String physiciansSpecializationId) {
        this.physiciansSpecializationId = physiciansSpecializationId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSelectedImageUrl() {
        return selectedImageUrl;
    }

    public void setSelectedImageUrl(String selectedImageUrl) {
        this.selectedImageUrl = selectedImageUrl;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}