package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
@SerializedName("error")
    @Expose
    private Boolean error;
@SerializedName("code")
    @Expose
    private String code;
@SerializedName("data")
    @Expose
    private Data_ data;
@SerializedName("message")
    @Expose
    private String message;


    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
