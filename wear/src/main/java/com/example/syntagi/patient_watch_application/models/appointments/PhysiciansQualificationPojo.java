package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class PhysiciansQualificationPojo implements Serializable {
   private QualificationData qualificationData;
   private CollegePojo collegeData;

   public QualificationData getQualificationData() {
      return qualificationData;
   }

   public void setQualificationData(QualificationData qualificationData) {
      this.qualificationData = qualificationData;
   }

   public CollegePojo getCollegeData() {
      return collegeData;
   }

   public void setCollegeData(CollegePojo collegeData) {
      this.collegeData = collegeData;
   }
}