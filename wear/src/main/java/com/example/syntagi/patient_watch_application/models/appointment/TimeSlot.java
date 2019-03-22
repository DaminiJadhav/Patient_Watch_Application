package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeSlot {

@SerializedName("startTime")
@Expose
private String startTime;
@SerializedName("endTime")
@Expose
private String endTime;
@SerializedName("booked")
@Expose
private Boolean booked;
@SerializedName("startDateTime")
@Expose
private String startDateTime;
@SerializedName("endDateTime")
@Expose
private String endDateTime;
@SerializedName("time")
@Expose
private Integer time;
@SerializedName("expired")
@Expose
private Boolean expired;

public String getStartTime() {
return startTime;
}

public void setStartTime(String startTime) {
this.startTime = startTime;
}

public String getEndTime() {
return endTime;
}

public void setEndTime(String endTime) {
this.endTime = endTime;
}

public Boolean getBooked() {
return booked;
}

public void setBooked(Boolean booked) {
this.booked = booked;
}

public String getStartDateTime() {
return startDateTime;
}

public void setStartDateTime(String startDateTime) {
this.startDateTime = startDateTime;
}

public String getEndDateTime() {
return endDateTime;
}

public void setEndDateTime(String endDateTime) {
this.endDateTime = endDateTime;
}

public Integer getTime() {
return time;
}

public void setTime(Integer time) {
this.time = time;
}

public Boolean getExpired() {
return expired;
}

public void setExpired(Boolean expired) {
this.expired = expired;
}

}