package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClinicData_ {

@SerializedName("name")
@Expose
private String name;
@SerializedName("clinicAddress")
@Expose
private ClinicAddress clinicAddress;
@SerializedName("logo")
@Expose
private String logo;
@SerializedName("appointmentNumbers")
@Expose
private List<String> appointmentNumbers = null;
@SerializedName("patientOtpVerification")
@Expose
private Boolean patientOtpVerification;
@SerializedName("services")
@Expose
private List<Object> services = null;
@SerializedName("clinicId")
@Expose
private String clinicId;
@SerializedName("hideLetterHead")
@Expose
private Boolean hideLetterHead;
@SerializedName("pharmacyId")
@Expose
private String pharmacyId;
@SerializedName("companyId")
@Expose
private String companyId;
@SerializedName("code")
@Expose
private String code;
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

public List<String> getAppointmentNumbers() {
return appointmentNumbers;
}

public void setAppointmentNumbers(List<String> appointmentNumbers) {
this.appointmentNumbers = appointmentNumbers;
}

public Boolean getPatientOtpVerification() {
return patientOtpVerification;
}

public void setPatientOtpVerification(Boolean patientOtpVerification) {
this.patientOtpVerification = patientOtpVerification;
}

public List<Object> getServices() {
return services;
}

public void setServices(List<Object> services) {
this.services = services;
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

public String getPharmacyId() {
return pharmacyId;
}

public void setPharmacyId(String pharmacyId) {
this.pharmacyId = pharmacyId;
}

public String getCompanyId() {
return companyId;
}

public void setCompanyId(String companyId) {
this.companyId = companyId;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getFullAddress() {
return fullAddress;
}

public void setFullAddress(String fullAddress) {
this.fullAddress = fullAddress;
}

}