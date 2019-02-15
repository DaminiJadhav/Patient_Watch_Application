package com.example.syntagi.patient_watch_application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorEmergencyContact {
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
    @SerializedName("firstName")
    @Expose
    private Object firstName;
    @SerializedName("lastName")
    @Expose
    private Object lastName;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("number")
    @Expose
    private Object number;


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

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }
}
