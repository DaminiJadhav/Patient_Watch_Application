package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppointmentStatusData {

@SerializedName("created")
@Expose
private Integer created;
@SerializedName("updated")
@Expose
private Integer updated;
@SerializedName("createdBy")
@Expose
private String createdBy;
@SerializedName("updatedBy")
@Expose
private String updatedBy;
@SerializedName("createdByName")
@Expose
private String createdByName;
@SerializedName("updatedByName")
@Expose
private String updatedByName;
@SerializedName("createdByRole")
@Expose
private Integer createdByRole;
@SerializedName("updatedByRole")
@Expose
private Integer updatedByRole;
@SerializedName("userId")
@Expose
private String userId;
@SerializedName("userRole")
@Expose
private Integer userRole;
@SerializedName("appointmentStatus")
@Expose
private Integer appointmentStatus;

public Integer getCreated() {
return created;
}

public void setCreated(Integer created) {
this.created = created;
}

public Integer getUpdated() {
return updated;
}

public void setUpdated(Integer updated) {
this.updated = updated;
}

public String getCreatedBy() {
return createdBy;
}

public void setCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public String getUpdatedBy() {
return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
this.updatedBy = updatedBy;
}

public String getCreatedByName() {
return createdByName;
}

public void setCreatedByName(String createdByName) {
this.createdByName = createdByName;
}

public String getUpdatedByName() {
return updatedByName;
}

public void setUpdatedByName(String updatedByName) {
this.updatedByName = updatedByName;
}

public Integer getCreatedByRole() {
return createdByRole;
}

public void setCreatedByRole(Integer createdByRole) {
this.createdByRole = createdByRole;
}

public Integer getUpdatedByRole() {
return updatedByRole;
}

public void setUpdatedByRole(Integer updatedByRole) {
this.updatedByRole = updatedByRole;
}

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public Integer getUserRole() {
return userRole;
}

public void setUserRole(Integer userRole) {
this.userRole = userRole;
}

public Integer getAppointmentStatus() {
return appointmentStatus;
}

public void setAppointmentStatus(Integer appointmentStatus) {
this.appointmentStatus = appointmentStatus;
}

}