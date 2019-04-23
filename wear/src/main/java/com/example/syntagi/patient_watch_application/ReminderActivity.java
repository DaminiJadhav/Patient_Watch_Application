package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.enum_package.Reminder;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

public class ReminderActivity extends AppCompatActivity {
    MedicineData medicineData;

    public static void startReminderActivity(Fragment context, MedicineData medicineData) {
        Intent intent = new Intent(context.getActivity(), ReminderActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstants.BUNDLE_KEYS.MEDICINE_DATA, medicineData);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_details_db);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
                medicineData= (MedicineData) extras.getSerializable(AppConstants.BUNDLE_KEYS.MEDICINE_DATA);
        }
//        DatabaseHandler databaseHandler=new DatabaseHandler(ReminderActivity.this);
//        databaseHandler.addmedicine(medicineData,Reminder.MOR);
//        databaseHandler.getAllMedicineData();
//        databaseHandler.deleteRow();
    }

}

