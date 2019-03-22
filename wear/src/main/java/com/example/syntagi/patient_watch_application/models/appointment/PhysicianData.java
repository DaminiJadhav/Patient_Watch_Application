package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhysicianData {

@SerializedName("created")
@Expose
private Integer created;
@SerializedName("updated")
@Expose
private Integer updated;
@SerializedName("version")
@Expose
private Integer version;
@SerializedName("registrationNumber")
@Expose
private String registrationNumber;
@SerializedName("profile")
@Expose
private Profile profile;
@SerializedName("education")
@Expose
private Education education;
@SerializedName("certificates")
@Expose
private Certificates certificates;
@SerializedName("pin")
@Expose
private Integer pin;
@SerializedName("authorised")
@Expose
private Boolean authorised;
@SerializedName("declarationSigned")
@Expose
private Boolean declarationSigned;
@SerializedName("preferences")
@Expose
private Preferences preferences;
@SerializedName("letterHeadData")
@Expose
private List<String> letterHeadData = null;
@SerializedName("experience")
@Expose
private Experience experience;
@SerializedName("pinUpdated")
@Expose
private Boolean pinUpdated;
@SerializedName("remoteCharges")
@Expose
private RemoteCharges remoteCharges;
@SerializedName("multiLoginSupport")
@Expose
private Boolean multiLoginSupport;
@SerializedName("bankDetails")
@Expose
private BankDetails bankDetails;
@SerializedName("physicianId")
@Expose
private String physicianId;
@SerializedName("code")
@Expose
private String code;
@SerializedName("codeDate")
@Expose
private String codeDate;
@SerializedName("isFollowUp")
@Expose
private Boolean isFollowUp;

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

public Integer getVersion() {
return version;
}

public void setVersion(Integer version) {
this.version = version;
}

public String getRegistrationNumber() {
return registrationNumber;
}

public void setRegistrationNumber(String registrationNumber) {
this.registrationNumber = registrationNumber;
}

public Profile getProfile() {
return profile;
}

public void setProfile(Profile profile) {
this.profile = profile;
}

public Education getEducation() {
return education;
}

public void setEducation(Education education) {
this.education = education;
}

public Certificates getCertificates() {
return certificates;
}

public void setCertificates(Certificates certificates) {
this.certificates = certificates;
}

public Integer getPin() {
return pin;
}

public void setPin(Integer pin) {
this.pin = pin;
}

public Boolean getAuthorised() {
return authorised;
}

public void setAuthorised(Boolean authorised) {
this.authorised = authorised;
}

public Boolean getDeclarationSigned() {
return declarationSigned;
}

public void setDeclarationSigned(Boolean declarationSigned) {
this.declarationSigned = declarationSigned;
}

public Preferences getPreferences() {
return preferences;
}

public void setPreferences(Preferences preferences) {
this.preferences = preferences;
}

public List<String> getLetterHeadData() {
return letterHeadData;
}

public void setLetterHeadData(List<String> letterHeadData) {
this.letterHeadData = letterHeadData;
}

public Experience getExperience() {
return experience;
}

public void setExperience(Experience experience) {
this.experience = experience;
}

public Boolean getPinUpdated() {
return pinUpdated;
}

public void setPinUpdated(Boolean pinUpdated) {
this.pinUpdated = pinUpdated;
}

public RemoteCharges getRemoteCharges() {
return remoteCharges;
}

public void setRemoteCharges(RemoteCharges remoteCharges) {
this.remoteCharges = remoteCharges;
}

public Boolean getMultiLoginSupport() {
return multiLoginSupport;
}

public void setMultiLoginSupport(Boolean multiLoginSupport) {
this.multiLoginSupport = multiLoginSupport;
}

public BankDetails getBankDetails() {
return bankDetails;
}

public void setBankDetails(BankDetails bankDetails) {
this.bankDetails = bankDetails;
}

public String getPhysicianId() {
return physicianId;
}

public void setPhysicianId(String physicianId) {
this.physicianId = physicianId;
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

public Boolean getIsFollowUp() {
return isFollowUp;
}

public void setIsFollowUp(Boolean isFollowUp) {
this.isFollowUp = isFollowUp;
}

}
