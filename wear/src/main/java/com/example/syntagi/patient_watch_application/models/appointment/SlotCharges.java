package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SlotCharges {

    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("charges")
    @Expose
    private Integer charges;

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

}

