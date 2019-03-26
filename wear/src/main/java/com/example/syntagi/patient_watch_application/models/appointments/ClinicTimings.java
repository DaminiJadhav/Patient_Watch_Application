package com.example.syntagi.patient_watch_application.models.appointments;

import android.text.TextUtils;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ClinicTimings implements Serializable {

    private String timingFrom;
    private String timingTo;
    @SerializedName("days")
    private List<Integer> frequencies;
    private List<Integer> weekFrequencies;
    private boolean isExpand;

    public boolean isExpand() {
        if(TextUtils.isEmpty(timingFrom)){
            return true;
        }
        if(TextUtils.isEmpty(timingTo)){
            return true;
        }
        if(CollectionUtils.isEmpty(frequencies)){
            return true;
        }
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getTimingFrom() {
        return timingFrom;
    }

    public void setTimingFrom(String timingFrom) {
        this.timingFrom = timingFrom;
    }

    public String getTimingTo() {
        return timingTo;
    }

    public void setTimingTo(String timingTo) {
        this.timingTo = timingTo;
    }

    public List<Integer> getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(List<Integer> frequencies) {
        this.frequencies = frequencies;
    }

//    public String getFrequencyString() {
//        if(frequencies!=null&&frequencies.size()>0){
//            return Weeks.getWeeksList(frequencies);
//        }
//        return "";
//    }

    public List<Integer> getWeekFrequencies() {
        return weekFrequencies;
    }

    public void setWeekFrequencies(List<Integer> weekFrequencies) {
        this.weekFrequencies = weekFrequencies;
    }


}