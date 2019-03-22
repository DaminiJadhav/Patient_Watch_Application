package com.example.syntagi.patient_watch_application.models.appointment;

import com.example.syntagi.patient_watch_application.models.Address;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PatientData {

@SerializedName("created")
@Expose
private Integer created;
@SerializedName("updated")
@Expose
private Integer updated;
@SerializedName("version")
@Expose
private Integer version;
@SerializedName("salutation")
@Expose
private String salutation;
@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("name")
@Expose
private String name;
@SerializedName("dob")
@Expose
private String dob;
@SerializedName("gender")
@Expose
private String gender;
@SerializedName("emailId")
@Expose
private String emailId;
@SerializedName("phoneNumber")
@Expose
private String phoneNumber;
@SerializedName("imageUrl")
@Expose
private String imageUrl;
@SerializedName("upId")
@Expose
private String upId;
@SerializedName("aadharCardNo")
@Expose
private String aadharCardNo;
@SerializedName("language")
@Expose
private String language;
@SerializedName("diet")
@Expose
private String diet;
@SerializedName("address")
@Expose
private Address address;
@SerializedName("bloodGroup")
@Expose
private String bloodGroup;
@SerializedName("identificationMark")
@Expose
private String identificationMark;
@SerializedName("languagePreferences")
@Expose
private List<String> languagePreferences = null;
@SerializedName("emergencyContacts")
@Expose
private List<EmergencyContact> emergencyContacts = null;
@SerializedName("doctorEmergencyContact")
@Expose
private DoctorEmergencyContact doctorEmergencyContact;
@SerializedName("creatorId")
@Expose
private String creatorId;
@SerializedName("age")
@Expose
private String age;
@SerializedName("patientType")
@Expose
private Integer patientType;
@SerializedName("dependent")
@Expose
private Boolean dependent;
@SerializedName("patientOtpVerification")
@Expose
private Boolean patientOtpVerification;
@SerializedName("sourceType")
@Expose
private Integer sourceType;
@SerializedName("patientId")
@Expose
private String patientId;
@SerializedName("ageInYear")
@Expose
private Double ageInYear;
@SerializedName("dobInMilli")
@Expose
private Integer dobInMilli;
@SerializedName("profileMatch")
@Expose
private Boolean profileMatch;
@SerializedName("updateDependent")
@Expose
private Boolean updateDependent;
@SerializedName("messageStatus")
@Expose
private Integer messageStatus;
@SerializedName("married")
@Expose
private Boolean married;

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

public String getSalutation() {
return salutation;
}

public void setSalutation(String salutation) {
this.salutation = salutation;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDob() {
return dob;
}

public void setDob(String dob) {
this.dob = dob;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getEmailId() {
return emailId;
}

public void setEmailId(String emailId) {
this.emailId = emailId;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

public String getUpId() {
return upId;
}

public void setUpId(String upId) {
this.upId = upId;
}

public String getAadharCardNo() {
return aadharCardNo;
}

public void setAadharCardNo(String aadharCardNo) {
this.aadharCardNo = aadharCardNo;
}

public String getLanguage() {
return language;
}

public void setLanguage(String language) {
this.language = language;
}

public String getDiet() {
return diet;
}

public void setDiet(String diet) {
this.diet = diet;
}

public Address getAddress() {
return address;
}

public void setAddress(Address address) {
this.address = address;
}

public String getBloodGroup() {
return bloodGroup;
}

public void setBloodGroup(String bloodGroup) {
this.bloodGroup = bloodGroup;
}

public String getIdentificationMark() {
return identificationMark;
}

public void setIdentificationMark(String identificationMark) {
this.identificationMark = identificationMark;
}

public List<String> getLanguagePreferences() {
return languagePreferences;
}

public void setLanguagePreferences(List<String> languagePreferences) {
this.languagePreferences = languagePreferences;
}

public List<EmergencyContact> getEmergencyContacts() {
return emergencyContacts;
}

public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
this.emergencyContacts = emergencyContacts;
}

public DoctorEmergencyContact getDoctorEmergencyContact() {
return doctorEmergencyContact;
}

public void setDoctorEmergencyContact(DoctorEmergencyContact doctorEmergencyContact) {
this.doctorEmergencyContact = doctorEmergencyContact;
}

public String getCreatorId() {
return creatorId;
}

public void setCreatorId(String creatorId) {
this.creatorId = creatorId;
}

public String getAge() {
return age;
}

public void setAge(String age) {
this.age = age;
}

public Integer getPatientType() {
return patientType;
}

public void setPatientType(Integer patientType) {
this.patientType = patientType;
}

public Boolean getDependent() {
return dependent;
}

public void setDependent(Boolean dependent) {
this.dependent = dependent;
}

public Boolean getPatientOtpVerification() {
return patientOtpVerification;
}

public void setPatientOtpVerification(Boolean patientOtpVerification) {
this.patientOtpVerification = patientOtpVerification;
}

public Integer getSourceType() {
return sourceType;
}

public void setSourceType(Integer sourceType) {
this.sourceType = sourceType;
}

public String getPatientId() {
return patientId;
}

public void setPatientId(String patientId) {
this.patientId = patientId;
}

public Double getAgeInYear() {
return ageInYear;
}

public void setAgeInYear(Double ageInYear) {
this.ageInYear = ageInYear;
}

public Integer getDobInMilli() {
return dobInMilli;
}

public void setDobInMilli(Integer dobInMilli) {
this.dobInMilli = dobInMilli;
}

public Boolean getProfileMatch() {
return profileMatch;
}

public void setProfileMatch(Boolean profileMatch) {
this.profileMatch = profileMatch;
}

public Boolean getUpdateDependent() {
return updateDependent;
}

public void setUpdateDependent(Boolean updateDependent) {
this.updateDependent = updateDependent;
}

public Integer getMessageStatus() {
return messageStatus;
}

public void setMessageStatus(Integer messageStatus) {
this.messageStatus = messageStatus;
}

public Boolean getMarried() {
return married;
}

public void setMarried(Boolean married) {
this.married = married;
}

}