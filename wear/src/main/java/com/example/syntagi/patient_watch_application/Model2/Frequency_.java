package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Frequency_ {
    @SerializedName("morning")
    @Expose
    private Boolean morning;
    @SerializedName("noon")
    @Expose
    private Boolean noon;
    @SerializedName("evening")
    @Expose
    private Boolean evening;
    @SerializedName("night")
    @Expose
    private Boolean night;
    @SerializedName("afterMeals")
    @Expose
    private Boolean afterMeals;
    @SerializedName("morningDose")
    @Expose
    private Integer morningDose;
    @SerializedName("noonDose")
    @Expose
    private Integer noonDose;
    @SerializedName("eveningDose")
    @Expose
    private Integer eveningDose;
    @SerializedName("nightDose")
    @Expose
    private Integer nightDose;
    @SerializedName("frequency")
    @Expose
    private Integer frequency;
    @SerializedName("sosId")
    @Expose
    private String sosId;
    @SerializedName("sosString")
    @Expose
    private String sosString;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("comments_SL")
    @Expose
    private Object commentsSL;
    @SerializedName("mealsString")
    @Expose
    private String mealsString;
    @SerializedName("times")
    @Expose
    private String times;

    public Boolean getMorning() {
        return morning;
    }

    public void setMorning(Boolean morning) {
        this.morning = morning;
    }

    public Boolean getNoon() {
        return noon;
    }

    public void setNoon(Boolean noon) {
        this.noon = noon;
    }

    public Boolean getEvening() {
        return evening;
    }

    public void setEvening(Boolean evening) {
        this.evening = evening;
    }

    public Boolean getNight() {
        return night;
    }

    public void setNight(Boolean night) {
        this.night = night;
    }

    public Boolean getAfterMeals() {
        return afterMeals;
    }

    public void setAfterMeals(Boolean afterMeals) {
        this.afterMeals = afterMeals;
    }

    public Integer getMorningDose() {
        return morningDose;
    }

    public void setMorningDose(Integer morningDose) {
        this.morningDose = morningDose;
    }

    public Integer getNoonDose() {
        return noonDose;
    }

    public void setNoonDose(Integer noonDose) {
        this.noonDose = noonDose;
    }

    public Integer getEveningDose() {
        return eveningDose;
    }

    public void setEveningDose(Integer eveningDose) {
        this.eveningDose = eveningDose;
    }

    public Integer getNightDose() {
        return nightDose;
    }

    public void setNightDose(Integer nightDose) {
        this.nightDose = nightDose;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Object getCommentsSL() {
        return commentsSL;
    }

    public void setCommentsSL(Object commentsSL) {
        this.commentsSL = commentsSL;
    }

    public String getMealsString() {
        return mealsString;
    }

    public void setMealsString(String mealsString) {
        this.mealsString = mealsString;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }



}
