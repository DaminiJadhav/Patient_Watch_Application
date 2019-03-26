package com.example.syntagi.patient_watch_application.models.appointments;

import java.io.Serializable;

public class QualificationPojo implements Serializable {
   private String qualificationName;


   public String getQualificationName(){
      if(qualificationName==null){
         qualificationName="";
      }
      return qualificationName;
   }

   public void setQualificationName(String qualificationName){
      this.qualificationName=qualificationName;
   }
}