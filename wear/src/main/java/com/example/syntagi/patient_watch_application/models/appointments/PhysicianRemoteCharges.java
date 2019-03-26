package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class PhysicianRemoteCharges implements Serializable {
   private boolean support;
   private long minimumDuration;
   private ChargesSlot firstSlotCharges;
   private ChargesSlot slotCharges;
   private double charges;

   public boolean isSupport() {
      return support;
   }

   public void setSupport(boolean support) {
      this.support = support;
   }

   public long getMinimumDuration() {
      return minimumDuration;
   }

   public void setMinimumDuration(long minimumDuration) {
      this.minimumDuration = minimumDuration;
   }

   public ChargesSlot getFirstSlotCharges() {
      return firstSlotCharges;
   }

   public void setFirstSlotCharges(ChargesSlot firstSlotCharges) {
      this.firstSlotCharges = firstSlotCharges;
   }

   public ChargesSlot getSlotCharges() {
      return slotCharges;
   }

   public void setSlotCharges(ChargesSlot slotCharges) {
      this.slotCharges = slotCharges;
   }

   public double getCharges() {
      return charges;
   }

   public void setCharges(double charges) {
      this.charges = charges;
   }
}