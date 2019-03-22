package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuggestedTimeSlot {

@SerializedName("timeFrequency")
@Expose
private Integer timeFrequency;
@SerializedName("booked")
@Expose
private Boolean booked;
@SerializedName("expired")
@Expose
private Boolean expired;

public Integer getTimeFrequency() {
return timeFrequency;
}

public void setTimeFrequency(Integer timeFrequency) {
this.timeFrequency = timeFrequency;
}

public Boolean getBooked() {
return booked;
}

public void setBooked(Boolean booked) {
this.booked = booked;
}

public Boolean getExpired() {
return expired;
}

public void setExpired(Boolean expired) {
this.expired = expired;
}

}
