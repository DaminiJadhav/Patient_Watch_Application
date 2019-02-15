package com.example.syntagi.patient_watch_application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    @SerializedName("created")
    @Expose
    private Integer created;

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @SerializedName("updated")
    @Expose
    private Integer updated;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @SerializedName("version")
    @Expose
    private Integer version;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SerializedName("firstName")
    @Expose
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SerializedName("lastName")
    @Expose
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("name")
    @Expose
    private String name;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @SerializedName("dob")
    @Expose
    private String dob;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @SerializedName("gender")
    @Expose
    private String gender;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @SerializedName("emailId")
    @Expose
    private String emailId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;


    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    @SerializedName("upId")
    @Expose
    private String upId;

    public String getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    @SerializedName("aadharCardNo")
    @Expose
    private String aadharCardNo;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @SerializedName("language")
    @Expose
    private String language;

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    @SerializedName("diet")
    @Expose
    private String diet;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @SerializedName("address")
    @Expose
    private Address address;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @SerializedName("bloodGroup")
    @Expose
    private String bloodGroup;

    public String getIdentificationMark() {
        return identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    @SerializedName("identificationMark")
    @Expose
    private String identificationMark;

    public List<String> getLanguagePreferences() {
        return languagePreferences;
    }

    public void setLanguagePreferences(List<String> languagePreferences) {
        this.languagePreferences = languagePreferences;
    }

    @SerializedName("languagePreferences")
    @Expose
    private List<String> languagePreferences=null;

    @SerializedName("emergencyContacts")
    @Expose
    private List<EmergencyContact> emergencyContacts=null;

    @SerializedName("doctorEmergencyContact")
    @Expose
    private DoctorEmergencyContact doctorEmergencyContact;

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    @SerializedName("married")
    @Expose
    private Boolean married;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @SerializedName("age")
    @Expose
    private String age;

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    @SerializedName("patientType")
    @Expose
    private Integer patientType;

    public Boolean getPatientOtpVerification() {
        return patientOtpVerification;
    }

    public void setPatientOtpVerification(Boolean patientOtpVerification) {
        this.patientOtpVerification = patientOtpVerification;
    }

    @SerializedName("patientOtpVerification")
    @Expose
    private Boolean patientOtpVerification;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @SerializedName("patientId")
    @Expose
    private String patientId;

    public Double getAgeInYear() {
        return ageInYear;
    }

    public void setAgeInYear(Double ageInYear) {
        this.ageInYear = ageInYear;
    }
    @SerializedName("ageInYear")
    @Expose
    private Double ageInYear;

    public Integer getDobInMilli() {
        return dobInMilli;
    }

    public void setDobInMilli(Integer dobInMilli) {
        this.dobInMilli = dobInMilli;
    }
    @SerializedName("dobInMilli")
    @Expose
    private Integer dobInMilli;

    public Boolean getProfileMatch() {
        return profileMatch;
    }

    public void setProfileMatch(Boolean profileMatch) {
        this.profileMatch = profileMatch;
    }
    @SerializedName("profileMatch")
    @Expose
    private Boolean profileMatch;


    public Boolean getUpdateDependent() {
        return updateDependent;
    }

    public void setUpdateDependent(Boolean updateDependent) {
        this.updateDependent = updateDependent;
    }


    @SerializedName("updateDependent")
    @Expose
    private Boolean updateDependent;

}
