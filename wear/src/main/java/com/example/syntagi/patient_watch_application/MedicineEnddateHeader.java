package com.example.syntagi.patient_watch_application;

import android.os.Bundle;
import android.widget.TextView;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import androidx.appcompat.app.AppCompatActivity;

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
//            enddatetext.setText("" +enddate);
//
//        }

    }
}
