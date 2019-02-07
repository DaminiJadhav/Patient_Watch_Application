package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Constituent__ {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("strength")
    @Expose
    private String strength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }


}
