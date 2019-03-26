package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;
import java.util.List;

public class PhysiciansExperience implements Serializable {
   private Float totalExperience;
   private List<WorkPlace> workPlaces;

   public Float getTotalExperience() {
      return totalExperience;
   }

   public void setTotalExperience(Float totalExperience) {
      this.totalExperience = totalExperience;
   }


   public List<WorkPlace> getWorkPlaces() {
      return workPlaces;
   }

   public void setWorkPlaces(List<WorkPlace> workPlaces) {
      this.workPlaces = workPlaces;
   }
}
