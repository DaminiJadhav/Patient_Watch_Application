package com.example.syntagi.patient_watch_application.models;

import java.io.Serializable;
import java.util.List;

public class PatientData extends PatientProfileData implements Serializable {
    private List<DependentsData> associatedDependents;
    private List<DateWiseDiagnosisResponse> diagnosisDataList;
    private boolean patientOtpVerification;
    private boolean updateDependent;
    public String token;
    public String fcmToken;
    public int sourceType;

    public List<DependentsData> getAssociatedDependents() {
        return associatedDependents;
    }

    public void setAssociatedDependents(List<DependentsData> associatedDependents) {
        this.associatedDependents = associatedDependents;
    }

    public List<DateWiseDiagnosisResponse> getDiagnosisDataList() {
        return diagnosisDataList;
    }

    public void setDiagnosisDataList(List<DateWiseDiagnosisResponse> diagnosisDataList) {
        this.diagnosisDataList = diagnosisDataList;
    }

    public boolean isPatientOtpVerification() {
        return patientOtpVerification;
    }

    public void setPatientOtpVerification(boolean patientOtpVerification) {
        this.patientOtpVerification = patientOtpVerification;
    }

    public boolean isUpdateDependent() {
        return updateDependent;
    }

    public void setUpdateDependent(boolean updateDependent) {
        this.updateDependent = updateDependent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }
}