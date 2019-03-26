package com.example.syntagi.patient_watch_application.models.appointments;

import android.text.TextUtils;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Education implements Serializable {
    @SerializedName(PhysicianData.Fields.QUALIFICATION_LIST)
    private List<PhysiciansQualificationPojo> qualificationsList;
    @SerializedName(PhysicianData.Fields.SPECIALIZATION_LIST)
    private List<SpecializationData> specializationList;

    public String getQualificationsListToString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(qualificationsList)) {
            for (PhysiciansQualificationPojo physiciansQualificationPojo : qualificationsList) {
                if (physiciansQualificationPojo.getQualificationData() != null&&!TextUtils.isEmpty(physiciansQualificationPojo.getQualificationData().getQualificationName())) {
                    stringBuilder.append(physiciansQualificationPojo.getQualificationData().getQualificationName()).append(",");
                }
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
//
//    public String getSpecializationListToString() {
//        return CollectionUtils.getSpecializationToString(specializationList);
//    }

    public List<PhysiciansQualificationPojo> getQualificationsList() {
        return qualificationsList;
    }

    public void setQualificationsList(List<PhysiciansQualificationPojo> qualificationsList) {
        this.qualificationsList = qualificationsList;
    }

    public List<SpecializationData> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<SpecializationData> specializationList) {
        this.specializationList = specializationList;
    }
}