package com.example.syntagi.patient_watch_application.models.vitals;

import java.io.Serializable;

public class VitalChartData implements Serializable {
   private Double value;
   private String vitalId;

   public Double getValue() {
      return value;
   }

   public void setValue(Double value) {
      this.value = value;
   }

   public String getVitalId() {
      return vitalId;
   }

   public void setVitalId(String vitalId) {
      this.vitalId = vitalId;
   }
}
