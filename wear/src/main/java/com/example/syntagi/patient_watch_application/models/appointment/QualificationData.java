package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QualificationData {

@SerializedName("created")
@Expose
private Integer created;
@SerializedName("updated")
@Expose
private Integer updated;
@SerializedName("qualificationName")
@Expose
private String qualificationName;
@SerializedName("qualificationId")
@Expose
private String qualificationId;
@SerializedName("verified")
@Expose
private Boolean verified;
@SerializedName("creatorType")
@Expose
private Integer creatorType;

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

public String getQualificationName() {
return qualificationName;
}

public void setQualificationName(String qualificationName) {
this.qualificationName = qualificationName;
}

public String getQualificationId() {
return qualificationId;
}

public void setQualificationId(String qualificationId) {
this.qualificationId = qualificationId;
}

public Boolean getVerified() {
return verified;
}

public void setVerified(Boolean verified) {
this.verified = verified;
}

public Integer getCreatorType() {
return creatorType;
}

public void setCreatorType(Integer creatorType) {
this.creatorType = creatorType;
}

}