package com.example.syntagi.patient_watch_application;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;


public class  MyMedicine extends Fragment {
    MedicationEndsOn medicineData;

    public static MyMedicine getInstance(MedicationEndsOn medicineData) {
        MyMedicine myMedicine=new MyMedicine();
        myMedicine.medicineData = medicineData;
        return myMedicine;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.my_medicinefragment,container,false);
        TextView tvMedicineName,tvMedicineEndDate;
        tvMedicineEndDate = view.findViewById(R.id.tv_medicine_end_date);
        tvMedicineName = view.findViewById(R.id.tv_medicine_name);

        tvMedicineName.setText("Medicine Name:\n" +medicineData.getMedication().getMedicineName());
        tvMedicineEndDate.setText("End date:\n" +medicineData.getEndDate());
        return view;
    }
}
