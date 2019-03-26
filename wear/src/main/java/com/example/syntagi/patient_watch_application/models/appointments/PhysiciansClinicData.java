package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;
import java.util.List;

public class PhysiciansClinicData extends ClinicData implements Serializable {
    private List<ClinicTimings> clinicTimingList;
    private Integer role=1;
    private Long minimumConsultationDuration=0l;


    public List<ClinicTimings> getClinicTimingList() {
        return clinicTimingList;
    }

    public void setClinicTimingList(List<ClinicTimings> clinicTimingList) {
        this.clinicTimingList = clinicTimingList;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
