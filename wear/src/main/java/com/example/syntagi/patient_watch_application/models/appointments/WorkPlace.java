package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class WorkPlace implements Serializable {
   private Float experience;
   private String startMonthYear;
   private String endMonthYear;
   private Boolean currentlyWorking;
   private ClinicData clinicData;

   public Float getExperience() {
      return experience;
   }

   public void setExperience(Float experience) {
      this.experience = experience;
   }

   public String getStartMonthYear() {
      if(startMonthYear==null){
         return "";
      }
      return startMonthYear;
   }

   public void setStartMonthYear(String startMonthYear) {
      this.startMonthYear = startMonthYear;
   }

   public String getEndMonthYear() {
      if(endMonthYear==null){
         return "";
      }
      return endMonthYear;
   }

   public void setEndMonthYear(String endMonthYear) {
      this.endMonthYear = endMonthYear;
   }

   public Boolean getCurrentlyWorking() {
      if(currentlyWorking==null){
         currentlyWorking=false;
      }
      return currentlyWorking;
   }

   public void setCurrentlyWorking(Boolean currentlyWorking) {
      this.currentlyWorking = currentlyWorking;
   }

   public ClinicData getClinicData() {
      return clinicData;
   }

   public void setClinicData(ClinicData clinicData) {
      this.clinicData = clinicData;
   }


}
