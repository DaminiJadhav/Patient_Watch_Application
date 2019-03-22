package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseApiData {
    @SerializedName("created")
    @Expose
    private Object created;
    @SerializedName("updated")
    @Expose
    private Object updated;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("createdByName")
    @Expose
    private Object createdByName;
    @SerializedName("updatedByName")
    @Expose
    private Object updatedByName;
    @SerializedName("createdByRole")
    @Expose
    private Object createdByRole;
    @SerializedName("updatedByRole")
    @Expose
    private Object updatedByRole;
    @SerializedName("version")
    @Expose
    private Object version;

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }

    public Object getUpdated() {
        return updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(Object createdByName) {
        this.createdByName = createdByName;
    }

    public Object getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(Object updatedByName) {
        this.updatedByName = updatedByName;
    }

    public Object getCreatedByRole() {
        return createdByRole;
    }

    public void setCreatedByRole(Object createdByRole) {
        this.createdByRole = createdByRole;
    }

    public Object getUpdatedByRole() {
        return updatedByRole;
    }

    public void setUpdatedByRole(Object updatedByRole) {
        this.updatedByRole = updatedByRole;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }
}
