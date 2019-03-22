package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClinicData {

@SerializedName("name")
@Expose
private String name;
@SerializedName("clinicAddress")
@Expose
private ClinicAddress clinicAddress;
@SerializedName("logo")
@Expose
private String logo;
@SerializedName("patientOtpVerification")
@Expose
private Boolean patientOtpVerification;
@SerializedName("clinicId")
@Expose
private String clinicId;
@SerializedName("hideLetterHead")
@Expose
private Boolean hideLetterHead;
@SerializedName("fullAddress")
@Expose
private String fullAddress;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public ClinicAddress getClinicAddress() {
return clinicAddress;
}

public void setClinicAddress(ClinicAddress clinicAddress) {
this.clinicAddress = clinicAddress;
}

public String getLogo() {
return logo;
}

public void setLogo(String logo) {
this.logo = logo;
}

public Boolean getPatientOtpVerification() {
return patientOtpVerification;
}

public void setPatientOtpVerification(Boolean patientOtpVerification) {
this.patientOtpVerification = patientOtpVerification;
}

public String getClinicId() {
return clinicId;
}

public void setClinicId(String clinicId) {
this.clinicId = clinicId;
}

public Boolean getHideLetterHead() {
return hideLetterHead;
}

public void setHideLetterHead(Boolean hideLetterHead) {
this.hideLetterHead = hideLetterHead;
}

public String getFullAddress() {
return fullAddress;
}

public void setFullAddress(String fullAddress) {
this.fullAddress = fullAddress;
}

}