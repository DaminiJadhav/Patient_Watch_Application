package com.example.syntagi.patient_watch_application.models.appointments;

import com.example.syntagi.patient_watch_application.models.Address;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhysicianProfile implements Serializable {
    @SerializedName(PhysicianData.Fields.FIRST_NAME)
    private String firstName;
    @SerializedName(PhysicianData.Fields.LAST_NAME)
    private String lastName;
    @SerializedName(PhysicianData.Fields.FULL_NAME)
    public String fullname;
    @SerializedName(PhysicianData.Fields.EMAIL)
    private String emailId;
    @SerializedName(PhysicianData.Fields.GENDER)
    private String gender;
    @SerializedName(PhysicianData.Fields.DATE_OF_BIRTH)
    private String dateOfBirth;
    @SerializedName(PhysicianData.Fields.IMAGE_URL)
    private String imageUrl;
    @SerializedName(PhysicianData.Fields.ADDRESS)
    private Address address;
    @SerializedName(PhysicianData.Fields.PHONE_NUMBER)
    private String phoneNumber;
    @SerializedName(PhysicianData.Fields.ALTERNATE_PHONE_NUMBER)
    private String alternatePhoneNumber;
    @SerializedName(PhysicianData.Fields.ABOUT_ME)
    private String aboutMe;
    private String workingSince;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getWorkingSince() {
        return workingSince;
    }

    public void setWorkingSince(String workingSince) {
        this.workingSince = workingSince;
    }
}