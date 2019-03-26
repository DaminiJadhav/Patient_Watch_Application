package com.example.syntagi.patient_watch_application.models.appointments;

import com.example.syntagi.patient_watch_application.models.PatientData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppointmentData  implements Serializable {
    @SerializedName("physicianId")
    @Expose
    private String physicianId;
    @SerializedName("clinicId")
    @Expose
    private String clinicId;
    @SerializedName("patientId")
    @Expose
    public String patientId;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("timeSlot")
    @Expose
    public TimeSlot timeSlot;
    @SerializedName("appointmentType")
    @Expose
    private Integer appointmentType;
    @SerializedName("consultationType")
    @Expose
    private Integer consultationType;
    @SerializedName("description")
    @Expose
    public String description;

    public PhysicianData physicianData;
    public ClinicData clinicData;
    public PatientData patientData;
    private RequestedAppointmentData patientSuggestion;
    private RequestedAppointmentData doctorSuggestion;
    @SerializedName("appointmentId")
    @Expose
    public String appointmentId;
    @SerializedName("appointmentStatus")
    @Expose
    public int appointmentStatus;
    @SerializedName("amount")
    @Expose
    public Double amount;
    @SerializedName("paymentStatus")
    @Expose
    public Integer paymentStatus;
    public Boolean allowVideoCallPhysician;
    public Boolean allowVideoCallPatient;

    public void setPhysicianData(PhysicianData physicianData) {
        if (physicianData != null) {
            this.physicianId = physicianData.getPhysicianId();
        } else {
            this.physicianId = null;
        }
        this.physicianData = physicianData;
    }

    public void setClinicData(ClinicData clinicData) {
        if (clinicData != null) {
            this.clinicId = clinicData.getClinicId();
        }
        this.clinicData = clinicData;
    }

    public void setPatientData(PatientData patientData) {
        if (patientData != null) {
            this.patientId = patientData.getPatientId();
        }
        this.patientData = patientData;
    }


//
//    public String getPatientSuggestionString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (getPatientSuggestion() != null) {
//            stringBuilder.append("Suggested Date: ")
//                    .append(SyntagiDateUtils.convertDateFormat(getPatientSuggestion().getSuggestedDate(), SyntagiDateUtils.BASE_DATE_FORMAT, SyntagiDateUtils.PRESCRIPTION_DATE_FORMAT));
//            if (CollectionUtils.isNotEmpty(getPatientSuggestion().getSuggestedTimeSlots())) {
//                TimeFrequency frequency = TimeFrequency.findByCode(getPatientSuggestion().getSuggestedTimeSlots().get(0).getTimeFrequency());
//                if (frequency != null) {
//                    stringBuilder.append(" ").append(frequency.getTitle());
//                }
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    public String getDoctorSuggestionString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (getDoctorSuggestion() != null) {
//            stringBuilder.append("Suggested Date: ")
//                    .append(SyntagiDateUtils.convertDateFormat(getDoctorSuggestion().getSuggestedDate(), SyntagiDateUtils.BASE_DATE_FORMAT, SyntagiDateUtils.PRESCRIPTION_DATE_FORMAT));
//            if (CollectionUtils.isNotEmpty(getDoctorSuggestion().getSuggestedTimeSlots())) {
//                TimeFrequency frequency = TimeFrequency.findByCode(getDoctorSuggestion().getSuggestedTimeSlots().get(0).getTimeFrequency());
//                if (frequency != null) {
//                    stringBuilder.append(" ").append(frequency.getTitle());
//                } else {
//                    stringBuilder.append(" ").append(getDoctorSuggestion().getSuggestedTimeSlots().get(0).getStartTime());
//                }
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    public String getDateTimeString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (getDate() != null) {
//            stringBuilder.append(SyntagiDateUtils.convertDateFormat(getDate(), SyntagiDateUtils.BASE_DATE_FORMAT, SyntagiDateUtils.PRESCRIPTION_DATE_FORMAT));
//            if (getTimeSlot() != null) {
//                stringBuilder.append(" ").append(getTimeSlot().getStartTime());
//            }
//        }
//        return stringBuilder.toString();
//    }

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

    public PhysicianData getPhysicianData() {
        return physicianData;
    }

    public ClinicData getClinicData() {
        return clinicData;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public RequestedAppointmentData getPatientSuggestion() {
        return patientSuggestion;
    }

    public void setPatientSuggestion(RequestedAppointmentData patientSuggestion) {
        this.patientSuggestion = patientSuggestion;
    }

    public RequestedAppointmentData getDoctorSuggestion() {
        return doctorSuggestion;
    }

    public void setDoctorSuggestion(RequestedAppointmentData doctorSuggestion) {
        this.doctorSuggestion = doctorSuggestion;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(int appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
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

}