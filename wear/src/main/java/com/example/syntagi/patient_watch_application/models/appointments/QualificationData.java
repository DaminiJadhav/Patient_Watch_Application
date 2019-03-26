package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class QualificationData extends QualificationPojo implements Serializable {
   private String qualificationId;
   private Boolean verified;
   private Integer creatorType;
   private String creatorId;
   private Long created;
   private Long updated;

   public String getQualificationId() {
      return qualificationId;
   }

   public void setQualificationId(String qualificationId) {
      this.qualificationId = qualificationId;
   }

   public Long getCreated() {
      return created;
   }

   public void setCreated(Long created) {
      this.created = created;
   }

   public Long getUpdated() {
      return updated;
   }

   public void setUpdated(Long updated) {
      this.updated = updated;
   }

   public Boolean getVerified() {
      return verified;
   }

   public void setVerified(Boolean verified) {
      this.verified = verified;
   }

   public Integer getCreatorType() {
      return creatorType;
   }

   public void setCreatorType(Integer creatorType) {
      this.creatorType = creatorType;
   }

   public String getCreatorId() {
      return creatorId;
   }

   public void setCreatorId(String creatorId) {
      this.creatorId = creatorId;
   }

   @Override
   public String toString() {
      return getQualificationName();
   }
}