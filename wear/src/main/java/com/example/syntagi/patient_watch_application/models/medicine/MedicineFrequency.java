package com.example.syntagi.patient_watch_application.models.medicine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MedicineFrequency implements Serializable {
    @SerializedName("comments")
    @Expose
    public String comments;
    @SerializedName("comments_SL")
    @Expose
    public String comments_SL;
    @SerializedName("morning")
    @Expose
    private boolean morning;
    @SerializedName("noon")
    @Expose
    private boolean noon;
    @SerializedName("evening")
    @Expose
    private boolean evening;
    @SerializedName("night")
    @Expose
    private boolean night;
    @SerializedName("afterMeals")
    @Expose
    private boolean afterMeals = true;
    @SerializedName("morningDose")
    @Expose
    private float morningDose;
    @SerializedName("noonDose")
    @Expose
    private float noonDose;
    @SerializedName("eveningDose")
    @Expose
    private float eveningDose;
    @SerializedName("nightDose")
    @Expose
    private float nightDose;
    @SerializedName("frequency")
    @Expose
    private int frequency;
    @SerializedName("sosId")
    @Expose
    private String sosId;
    @SerializedName("sosString")
    @Expose
    private String sosString;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments_SL() {
        return comments_SL;
    }

    public void setComments_SL(String comments_SL) {
        this.comments_SL = comments_SL;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isNoon() {
        return noon;
    }

    public void setNoon(boolean noon) {
        this.noon = noon;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public boolean isNight() {
        return night;
    }

    public void setNight(boolean night) {
        this.night = night;
    }

    public boolean isAfterMeals() {
        return afterMeals;
    }

    public void setAfterMeals(boolean afterMeals) {
        this.afterMeals = afterMeals;
    }

    public float getMorningDose() {
        return morningDose;
    }

    public void setMorningDose(float morningDose) {
        this.morningDose = morningDose;
    }

    public float getNoonDose() {
        return noonDose;
    }

    public void setNoonDose(float noonDose) {
        this.noonDose = noonDose;
    }

    public float getEveningDose() {
        return eveningDose;
    }

    public void setEveningDose(float eveningDose) {
        this.eveningDose = eveningDose;
    }

    public float getNightDose() {
        return nightDose;
    }

    public void setNightDose(float nightDose) {
        this.nightDose = nightDose;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getSosId() {
        return sosId;
    }

    public void setSosId(String sosId) {
        this.sosId = sosId;
    }

    public String getSosString() {
        return sosString;
    }

    public void setSosString(String sosString) {
        this.sosString = sosString;
    }
}