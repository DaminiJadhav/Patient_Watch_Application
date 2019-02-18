package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.example.syntagi.patient_watch_application.models.LoginData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.google.gson.Gson;

public class MedicineEnddateHeader extends AppCompatActivity {
TextView enddatetext;
    MedicationEndsOn medicationEndsOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_enddate_header);
        enddatetext=findViewById(R.id.headerenddate);


//        Intent intent=this.getIntent();
//        Bundle bundle = intent.getExtras();
//        if (bundle!=null)
//        {
//            String enddate=bundle.getString("medicinedata");
//
//        }

    }
}
