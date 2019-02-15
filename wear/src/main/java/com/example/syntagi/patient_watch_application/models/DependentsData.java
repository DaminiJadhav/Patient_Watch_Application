package com.example.syntagi.patient_watch_application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DependentsData implements Serializable {
    private String relationSheep;
    private Integer creatorType;
    private String creatorId;
    private String parentId;
    private PatientData dependent;
    @SerializedName("canAccess")
    @Expose
    private boolean canAccess;
    @SerializedName("canEdit")
    @Expose
    private boolean canEdit;

    private boolean canEditMyProfile;
    private boolean canAccessMyProfile;

}