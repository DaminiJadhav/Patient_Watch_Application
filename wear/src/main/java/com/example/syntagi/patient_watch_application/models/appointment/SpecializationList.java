package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecializationList extends BaseApiData {
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("selectedImageUrl")
    @Expose
    private String selectedImageUrl;
    @SerializedName("snomedId")
    @Expose
    private Object snomedId;
    @SerializedName("physiciansSpecializationId")
    @Expose
    private String physiciansSpecializationId;
    @SerializedName("usedCount")
    @Expose
    private Integer usedCount;

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

    public Object getSnomedId() {
        return snomedId;
    }

    public void setSnomedId(Object snomedId) {
        this.snomedId = snomedId;
    }

    public String getPhysiciansSpecializationId() {
        return physiciansSpecializationId;
    }

    public void setPhysiciansSpecializationId(String physiciansSpecializationId) {
        this.physiciansSpecializationId = physiciansSpecializationId;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }
}
