package com.example.syntagi.patient_watch_application.models.appointment;

import com.example.syntagi.patient_watch_application.models.Address;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

@SerializedName("firstName")
@Expose
private String firstName;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("emailId")
@Expose
private String emailId;
@SerializedName("gender")
@Expose
private String gender;
@SerializedName("dateOfBirth")
@Expose
private String dateOfBirth;
@SerializedName("imageUrl")
@Expose
private String imageUrl;
@SerializedName("address")
@Expose
private Address address;
@SerializedName("phoneNumber")
@Expose
private String phoneNumber;
@SerializedName("alternatePhoneNumber")
@Expose
private String alternatePhoneNumber;
@SerializedName("aboutMe")
@Expose
private String aboutMe;
@SerializedName("workingSince")
@Expose
private String workingSince;
@SerializedName("experience")
@Expose
private Integer experience;

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

public Integer getExperience() {
return experience;
}

public void setExperience(Integer experience) {
this.experience = experience;
}

}