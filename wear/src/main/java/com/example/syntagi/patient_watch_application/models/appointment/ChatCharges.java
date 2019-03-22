package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatCharges {

    @SerializedName("support")
    @Expose
    private Boolean support;
    @SerializedName("minimumDuration")
    @Expose
    private Integer minimumDuration;
    @SerializedName("firstSlotCharges")
    @Expose
    private FirstSlotCharges firstSlotCharges;
    @SerializedName("slotCharges")
    @Expose
    private SlotCharges slotCharges;
    @SerializedName("charges")
    @Expose
    private Integer charges;

    public Boolean getSupport() {
        return support;
    }

    public void setSupport(Boolean support) {
        this.support = support;
    }

    public Integer getMinimumDuration() {
        return minimumDuration;
    }

    public void setMinimumDuration(Integer minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public FirstSlotCharges getFirstSlotCharges() {
        return firstSlotCharges;
    }

    public void setFirstSlotCharges(FirstSlotCharges firstSlotCharges) {
        this.firstSlotCharges = firstSlotCharges;
    }

    public SlotCharges getSlotCharges() {
        return slotCharges;
    }

    public void setSlotCharges(SlotCharges slotCharges) {
        this.slotCharges = slotCharges;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }
}

