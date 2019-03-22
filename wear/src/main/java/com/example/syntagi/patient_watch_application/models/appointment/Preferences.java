package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preferences {

@SerializedName("medicineViewType")
@Expose
private Integer medicineViewType;
@SerializedName("showFooterClinicName")
@Expose
private Boolean showFooterClinicName;
@SerializedName("showFooterRegistrationNumber")
@Expose
private Boolean showFooterRegistrationNumber;
@SerializedName("showFooterQualification")
@Expose
private Boolean showFooterQualification;
@SerializedName("showMedicineGeneric")
@Expose
private Boolean showMedicineGeneric;

public Integer getMedicineViewType() {
return medicineViewType;
}

public void setMedicineViewType(Integer medicineViewType) {
this.medicineViewType = medicineViewType;
}

public Boolean getShowFooterClinicName() {
return showFooterClinicName;
}

public void setShowFooterClinicName(Boolean showFooterClinicName) {
this.showFooterClinicName = showFooterClinicName;
}

public Boolean getShowFooterRegistrationNumber() {
return showFooterRegistrationNumber;
}

public void setShowFooterRegistrationNumber(Boolean showFooterRegistrationNumber) {
this.showFooterRegistrationNumber = showFooterRegistrationNumber;
}

public Boolean getShowFooterQualification() {
return showFooterQualification;
}

public void setShowFooterQualification(Boolean showFooterQualification) {
this.showFooterQualification = showFooterQualification;
}

public Boolean getShowMedicineGeneric() {
return showMedicineGeneric;
}

public void setShowMedicineGeneric(Boolean showMedicineGeneric) {
this.showMedicineGeneric = showMedicineGeneric;
}

}