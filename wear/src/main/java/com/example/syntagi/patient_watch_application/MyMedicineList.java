package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.CurrentMedicineResponse;
import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class MyMedicineList extends AppCompatActivity {
    TextView textView;
    GetMedicineData getMedicineData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medicine_list);
        textView=findViewById(R.id.medicine_data);

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(MyMedicineList.this);
        String json=sharedPreferences.getString("Medicine","");
        Gson gson=new Gson();
        getMedicineData=gson.fromJson(json,GetMedicineData.class);
        if (getMedicineData!=null){
            textView.setText("All Medicine List:" +getMedicineData.getCurrentMedicines());

//            Type listtype=new TypeToken<List<GetMedicineData>>() {}.getType();
//            List<GetMedicineData> getMedicineData1=gson.fromJson(json.toString(),listtype);


//            String [] medicinename=new String[getMedicineData.getCurrentMedicines().size()];
//            for (int i=0;i<getMedicineData.getCurrentMedicines().size();i++){
//
//                        Map<String, MedicationEndsOn> currentmedicine=getMedicineData.getCurrentMedicines();
//
//                          if (currentmedicine!=null){
//
//
//                              MedicineData medicineData=currentmedicine.get(i).getMedication();
//                              if (medicineData!=null){
//                                  medicinename[i]=medicineData.getMedicineName();
//                              }
//                          }
//
//
//            }
//            listView.setAdapter(new ArrayAdapter<String>(MyMedicineList.this,R.layout.row_current_medicine,medicinename));
        }

    }
}
