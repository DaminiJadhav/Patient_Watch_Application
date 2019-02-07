package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Constituent {
    @SerializedName("strength")
    @Expose
    private String strength;

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }


}
