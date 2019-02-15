package com.example.syntagi.patient_watch_application.models.medicine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConstituentData implements Serializable {
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
