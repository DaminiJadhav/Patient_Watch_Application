package com.example.syntagi.patient_watch_application.models.appointments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Certificates implements Serializable {

    @SerializedName("nameVsSpecializationCertiUrl")
    @Expose
    private Map<String,String> specializationCertiUrls = new HashMap<>();
    @SerializedName("letterHeadUrl")
    @Expose
    private String letterHeadUrl;
    @SerializedName("digitalSignatureUrl")
    @Expose
    private String digitalSignatureUrl;

    /**
     * @return The specializationCertiUrls
     */
    public Map<String, String> getSpecializationCertiUrls() {
        return specializationCertiUrls;
    }

    public void setSpecializationCertiUrls(Map<String, String> specializationCertiUrls) {
        this.specializationCertiUrls = specializationCertiUrls;
    }

    /**
     * @return The letterHeadUrl
     */
    public String getLetterHeadUrl() {
        return letterHeadUrl;
    }

    /**
     * @param letterHeadUrl The letterHeadUrl
     */
    public void setLetterHeadUrl(String letterHeadUrl) {
        this.letterHeadUrl = letterHeadUrl;
    }

    /**
     * @return The digitalSignatureUrl
     */
    public String getDigitalSignatureUrl() {
        return digitalSignatureUrl;
    }

    /**
     * @param digitalSignatureUrl The digitalSignatureUrl
     */
    public void setDigitalSignatureUrl(String digitalSignatureUrl) {
        this.digitalSignatureUrl = digitalSignatureUrl;
    }

}