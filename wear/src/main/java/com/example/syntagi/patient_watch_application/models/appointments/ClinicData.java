package com.example.syntagi.patient_watch_application.models.appointments;

import com.example.syntagi.patient_watch_application.models.Address;

import java.io.Serializable;
import java.util.List;

public class ClinicData implements Serializable {
    private String clinicId;
    public String name;
    private Address clinicAddress;
    private String logo;
    private String pharmacyId;
    private String companyId;
    private List<String> appointmentNumbers;
    private String fullAddress;
    private String code;
    private String codeDate;
    private boolean patientOtpVerification;
    private boolean hideLetterHead;
    private List<String> services;


    @Override
    public String toString() {
        if(name==null){
            return "";
        }
        return name;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(Address clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public List<String> getAppointmentNumbers() {
        return appointmentNumbers;
    }

    public void setAppointmentNumbers(List<String> appointmentNumbers) {
        this.appointmentNumbers = appointmentNumbers;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(String codeDate) {
        this.codeDate = codeDate;
    }

    public boolean isPatientOtpVerification() {
        return patientOtpVerification;
    }

    public void setPatientOtpVerification(boolean patientOtpVerification) {
        this.patientOtpVerification = patientOtpVerification;
    }

    public boolean isHideLetterHead() {
        return hideLetterHead;
    }

    public void setHideLetterHead(boolean hideLetterHead) {
        this.hideLetterHead = hideLetterHead;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}