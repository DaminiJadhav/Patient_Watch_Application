package com.example.syntagi.patient_watch_application.Model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Data_ {
    @SerializedName("currentMedicines")
    @Expose
    private CurrentMedicines currentMedicines;

    public CurrentMedicines getCurrentMedicines() {
        return currentMedicines;
    }

    public void setCurrentMedicines(CurrentMedicines currentMedicines) {
        this.currentMedicines = currentMedicines;
    }
}
