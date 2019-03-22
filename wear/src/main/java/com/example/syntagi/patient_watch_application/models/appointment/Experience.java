package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Experience {

@SerializedName("totalExperience")
@Expose
private Integer totalExperience;
@SerializedName("diplayTotalExperience")
@Expose
private String diplayTotalExperience;
@SerializedName("lastExpUpdated")
@Expose
private Integer lastExpUpdated;
@SerializedName("workPlaces")
@Expose
private List<WorkPlace> workPlaces = null;

public Integer getTotalExperience() {
return totalExperience;
}

public void setTotalExperience(Integer totalExperience) {
this.totalExperience = totalExperience;
}

public String getDiplayTotalExperience() {
return diplayTotalExperience;
}

public void setDiplayTotalExperience(String diplayTotalExperience) {
this.diplayTotalExperience = diplayTotalExperience;
}

public Integer getLastExpUpdated() {
return lastExpUpdated;
}

public void setLastExpUpdated(Integer lastExpUpdated) {
this.lastExpUpdated = lastExpUpdated;
}

public List<WorkPlace> getWorkPlaces() {
return workPlaces;
}

public void setWorkPlaces(List<WorkPlace> workPlaces) {
this.workPlaces = workPlaces;
}

}