package com.example.syntagi.patient_watch_application.models.appointments;

import java.util.List;

public class RequestedAppointmentData extends BaseApiData {
   public String suggestedDate;
   public List<TimeSlot> suggestedTimeSlots;

   public String getSuggestedDate() {
      return suggestedDate;
   }

   public void setSuggestedDate(String suggestedDate) {
      this.suggestedDate = suggestedDate;
   }

   public List<TimeSlot> getSuggestedTimeSlots() {
      return suggestedTimeSlots;
   }

   public void setSuggestedTimeSlots(List<TimeSlot> suggestedTimeSlots) {
      this.suggestedTimeSlots = suggestedTimeSlots;
   }
}