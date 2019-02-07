package com.example.syntagi.patient_watch_application.Model1;

import java.io.Serializable;

public class LoginData implements Serializable {
    private PatientData patientData;
    private OtpResponseData otpResponseData;
    private String token;

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

    public OtpResponseData getOtpResponseData() {
        return otpResponseData;
    }

    public void setOtpResponseData(OtpResponseData otpResponseData) {
        this.otpResponseData = otpResponseData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
