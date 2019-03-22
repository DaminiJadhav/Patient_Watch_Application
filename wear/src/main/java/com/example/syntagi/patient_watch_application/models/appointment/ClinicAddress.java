package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClinicAddress {

@SerializedName("addressLine1")
@Expose
private String addressLine1;
@SerializedName("addressLine2")
@Expose
private String addressLine2;
@SerializedName("city")
@Expose
private String city;
@SerializedName("state")
@Expose
private String state;
@SerializedName("pincode")
@Expose
private String pincode;
@SerializedName("country")
@Expose
private String country;
@SerializedName("description")
@Expose
private String description;
@SerializedName("latitude")
@Expose
private String latitude;
@SerializedName("longitude")
@Expose
private String longitude;
@SerializedName("fullAddress")
@Expose
private String fullAddress;

public String getAddressLine1() {
return addressLine1;
}

public void setAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
}

public String getAddressLine2() {
return addressLine2;
}

public void setAddressLine2(String addressLine2) {
this.addressLine2 = addressLine2;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getPincode() {
return pincode;
}

public void setPincode(String pincode) {
this.pincode = pincode;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getLatitude() {
return latitude;
}

public void setLatitude(String latitude) {
this.latitude = latitude;
}

public String getLongitude() {
return longitude;
}

public void setLongitude(String longitude) {
this.longitude = longitude;
}

public String getFullAddress() {
return fullAddress;
}

public void setFullAddress(String fullAddress) {
this.fullAddress = fullAddress;
}

}