package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkPlace {

@SerializedName("experience")
@Expose
private Integer experience;
@SerializedName("startMonthYear")
@Expose
private String startMonthYear;
@SerializedName("endMonthYear")
@Expose
private String endMonthYear;
@SerializedName("currentlyWorking")
@Expose
private Boolean currentlyWorking;
@SerializedName("clinicData")
@Expose
private ClinicData clinicData;

public Integer getExperience() {
return experience;
}

public void setExperience(Integer experience) {
this.experience = experience;
}

public String getStartMonthYear() {
return startMonthYear;
}

public void setStartMonthYear(String startMonthYear) {
this.startMonthYear = startMonthYear;
}

public String getEndMonthYear() {
return endMonthYear;
}

public void setEndMonthYear(String endMonthYear) {
this.endMonthYear = endMonthYear;
}

public Boolean getCurrentlyWorking() {
return currentlyWorking;
}

public void setCurrentlyWorking(Boolean currentlyWorking) {
this.currentlyWorking = currentlyWorking;
}

public ClinicData getClinicData() {
return clinicData;
}

public void setClinicData(ClinicData clinicData) {
this.clinicData = clinicData;
}

}