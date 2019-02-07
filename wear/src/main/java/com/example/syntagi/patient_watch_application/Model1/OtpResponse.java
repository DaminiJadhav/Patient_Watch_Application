package com.example.syntagi.patient_watch_application.Model1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpResponse extends BaseApiResponse {
    @SerializedName("data")
    @Expose
    Boolean data;

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }
}
