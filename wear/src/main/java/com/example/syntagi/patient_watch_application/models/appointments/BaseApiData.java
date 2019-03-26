package com.example.syntagi.patient_watch_application.models.appointments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseApiData implements Serializable {
    public interface Fields{
        String ID = "id";
        String CREATED = "created";
        String UPDATED = "updated";
        String CREATED_BY = "createdBy";
        String UPDATED_BY = "updatedBy";
        String VERSION = "version";
    }

    @SerializedName(Fields.CREATED)
    @Expose
    private long created;
    @SerializedName(Fields.UPDATED)
    @Expose
    private long updated;
    @SerializedName(Fields.CREATED_BY)
    @Expose
    private String createdBy;
    @SerializedName(Fields.UPDATED_BY)
    @Expose
    private String updatedBy;
    @SerializedName(Fields.VERSION)
    @Expose
    private int version=1;

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}