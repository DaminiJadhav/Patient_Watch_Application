package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QualificationsList extends BaseApiData {
    @SerializedName("qualificationData")
    @Expose
    private QualificationData qualificationData;
    @SerializedName("collegeData")
    @Expose
    private CollegeData collegeData;

    public QualificationData getQualificationData() {
        return qualificationData;
    }

    public void setQualificationData(QualificationData qualificationData) {
        this.qualificationData = qualificationData;
    }

    public CollegeData getCollegeData() {
        return collegeData;
    }

    public void setCollegeData(CollegeData collegeData) {
        this.collegeData = collegeData;
    }
}
