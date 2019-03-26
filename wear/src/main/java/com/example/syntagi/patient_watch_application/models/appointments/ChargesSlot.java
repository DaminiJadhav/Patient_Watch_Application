package com.example.syntagi.patient_watch_application.models.appointments;

public class ChargesSlot extends BaseApiData{
   private Long duration;
   private Double charges;

   public Long getDuration() {
      return duration;
   }

   public void setDuration(Long duration) {
      this.duration = duration;
   }

   public Double getCharges() {
      return charges;
   }

   public void setCharges(Double charges) {
      this.charges = charges;
   }
}