package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Certificates {

@SerializedName("nameVsSpecializationCertiUrl")
@Expose
private NameVsSpecializationCertiUrl nameVsSpecializationCertiUrl;
@SerializedName("letterHeadUrl")
@Expose
private Object letterHeadUrl;
@SerializedName("digitalSignatureUrl")
@Expose
private String digitalSignatureUrl;

public NameVsSpecializationCertiUrl getNameVsSpecializationCertiUrl() {
return nameVsSpecializationCertiUrl;
}

public void setNameVsSpecializationCertiUrl(NameVsSpecializationCertiUrl nameVsSpecializationCertiUrl) {
this.nameVsSpecializationCertiUrl = nameVsSpecializationCertiUrl;
}

public Object getLetterHeadUrl() {
return letterHeadUrl;
}

public void setLetterHeadUrl(Object letterHeadUrl) {
this.letterHeadUrl = letterHeadUrl;
}

public String getDigitalSignatureUrl() {
return digitalSignatureUrl;
}

public void setDigitalSignatureUrl(String digitalSignatureUrl) {
this.digitalSignatureUrl = digitalSignatureUrl;
}

}