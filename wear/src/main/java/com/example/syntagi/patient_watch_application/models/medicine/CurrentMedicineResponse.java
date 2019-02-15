package com.example.syntagi.patient_watch_application.models.medicine;

import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentMedicineResponse extends BaseApiResponse {

    @SerializedName("data")
    @Expose
    private GetMedicineData data;

    public GetMedicineData getData() {
        return data;
    }

    public void setData(GetMedicineData data) {
        this.data = data;
    }
}
