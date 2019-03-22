package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameVsSpecializationCertiUrl {

@SerializedName("certificate two")
@Expose
private String certificateTwo;
@SerializedName("certificate one")
@Expose
private String certificateOne;

public String getCertificateTwo() {
return certificateTwo;
}

public void setCertificateTwo(String certificateTwo) {
this.certificateTwo = certificateTwo;
}

public String getCertificateOne() {
return certificateOne;
}

public void setCertificateOne(String certificateOne) {
this.certificateOne = certificateOne;
}

}