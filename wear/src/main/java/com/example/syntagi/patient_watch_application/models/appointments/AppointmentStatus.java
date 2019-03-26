package com.example.syntagi.patient_watch_application.models.appointments;

public enum AppointmentStatus {
    INITIATED(1, "Appointment requested"),
    ACCEPTED(2, "Appointment accepted"),
    VISIT_CLINIC(3, "Visit Clinic"),
    BOOKED(4, "Appointment booked"),
    CANCELED(5, "Appointment canceled"),
    EXPIRED(6, "Appointment expired"),
    RE_SCEDULED(7, "Appointment rescheduled"),
    COMPLETED(8, "Appointment completed"),
    VISIT_EMERGENCY(9, "Visit Emergency"),
    CLINIC_VISITED(10, "Visited in clinic"),;
    public Integer code;
    public String title;

    AppointmentStatus(Integer code, String title) {
        this.code = code;
        this.title = title;
    }

    public static AppointmentStatus findByCode(Integer code) {
        if (code != null) {
            for (AppointmentStatus appointmentStatus : AppointmentStatus.values()) {
                if (appointmentStatus.getCode().equals(code))
                    return appointmentStatus;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
