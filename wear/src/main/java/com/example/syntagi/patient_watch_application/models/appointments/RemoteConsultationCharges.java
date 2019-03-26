package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class RemoteConsultationCharges implements Serializable {
   private PhysicianRemoteCharges chatCharges;
   private PhysicianRemoteCharges audioCharges;
   private PhysicianRemoteCharges videoCharges;

   public PhysicianRemoteCharges getChatCharges() {
      return chatCharges;
   }

   public void setChatCharges(PhysicianRemoteCharges chatCharges) {
      this.chatCharges = chatCharges;
   }

   public PhysicianRemoteCharges getAudioCharges() {
      return audioCharges;
   }

   public void setAudioCharges(PhysicianRemoteCharges audioCharges) {
      this.audioCharges = audioCharges;
   }

   public PhysicianRemoteCharges getVideoCharges() {
      return videoCharges;
   }

   public void setVideoCharges(PhysicianRemoteCharges videoCharges) {
      this.videoCharges = videoCharges;
   }
}