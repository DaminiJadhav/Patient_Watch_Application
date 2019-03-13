package com.example.syntagi.patient_watch_application.models.medicine;

import java.io.Serializable;
import java.util.Map;

public class GetMedicineData implements Serializable {
    private Map<String, MedicationEndsOn> currentMedicines;

    public Map<String, MedicationEndsOn> getCurrentMedicines() {
        return currentMedicines;
    }

    public void setCurrentMedicines(Map<String, MedicationEndsOn> currentMedicines) {
        this.currentMedicines = currentMedicines;
    }

}
