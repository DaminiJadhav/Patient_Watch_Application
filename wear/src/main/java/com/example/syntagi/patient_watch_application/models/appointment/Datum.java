package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum extends BaseApiData {

    @SerializedName("physicianId")
    @Expose
    private String physicianId;
    @SerializedName("clinicId")
    @Expose
    private String clinicId;
    @SerializedName("patientId")
    @Expose
    private String patientId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("timeSlot")
    @Expose
    private TimeSlot timeSlot;
    @SerializedName("appointmentStatus")
    @Expose
    private Integer appointmentStatus;
    @SerializedName("appointmentType")
    @Expose
    private Integer appointmentType;
    @SerializedName("consultationType")
    @Expose
    private Integer consultationType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("patientSuggestion")
    @Expose
    private PatientSuggestion patientSuggestion;
    @SerializedName("patientData")
    @Expose
    private PatientData patientData;
    @SerializedName("physicianData")
    @Expose
    private PhysicianData physicianData;
    @SerializedName("clinicData")
    @Expose
    private ClinicData_ clinicData;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("paymentStatus")
    @Expose
    private Integer paymentStatus;
    @SerializedName("appointmentStatusData")
    @Expose
    private AppointmentStatusData appointmentStatusData;
    @SerializedName("allowVideoCallPhysician")
    @Expose
    private Boolean allowVideoCallPhysician;
    @SerializedName("allowVideoCallPatient")
    @Expose
    private Boolean allowVideoCallPatient;
    @SerializedName("appointmentId")
    @Expose
    private String appointmentId;
    @SerializedName("appointmentTime")
    @Expose
    private Integer appointmentTime;

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Integer getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(Integer appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Integer getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(Integer appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Integer getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(Integer consultationType) {
        this.consultationType = consultationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientSuggestion getPatientSuggestion() {
        return patientSuggestion;
    }

    public void setPatientSuggestion(PatientSuggestion patientSuggestion) {
        this.patientSuggestion = patientSuggestion;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

    public PhysicianData getPhysicianData() {
        return physicianData;
    }

    public void setPhysicianData(PhysicianData physicianData) {
        this.physicianData = physicianData;
    }

    public ClinicData_ getClinicData() {
        return clinicData;
    }

    public void setClinicData(ClinicData_ clinicData) {
        this.clinicData = clinicData;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public AppointmentStatusData getAppointmentStatusData() {
        return appointmentStatusData;
    }

    public void setAppointmentStatusData(AppointmentStatusData appointmentStatusData) {
        this.appointmentStatusData = appointmentStatusData;
    }

    public Boolean getAllowVideoCallPhysician() {
        return allowVideoCallPhysician;
    }

    public void setAllowVideoCallPhysician(Boolean allowVideoCallPhysician) {
        this.allowVideoCallPhysician = allowVideoCallPhysician;
    }

    public Boolean getAllowVideoCallPatient() {
        return allowVideoCallPatient;
    }

    public void setAllowVideoCallPatient(Boolean allowVideoCallPatient) {
        this.allowVideoCallPatient = allowVideoCallPatient;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Integer appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
