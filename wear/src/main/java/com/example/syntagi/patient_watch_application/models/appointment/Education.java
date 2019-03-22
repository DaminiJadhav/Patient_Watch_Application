package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Education {

@SerializedName("qualificationsList")
@Expose
private List<QualificationsList> qualificationsList = null;
@SerializedName("specializationList")
@Expose
private List<SpecializationList> specializationList = null;

public List<QualificationsList> getQualificationsList() {
return qualificationsList;
}

public void setQualificationsList(List<QualificationsList> qualificationsList) {
this.qualificationsList = qualificationsList;
}

public List<SpecializationList> getSpecializationList() {
return specializationList;
}

public void setSpecializationList(List<SpecializationList> specializationList) {
this.specializationList = specializationList;
}

}