package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        TextView tvMedicineName,tvMedicineEndDate,morningdose,lunchdose,eveningdose,nightdose;
//        tvMedicineEndDate = view.findViewById(R.id.tv_medicine_end_date);

        tvMedicineName = view.findViewById(R.id.tv_medicine_name);
        morningdose=view.findViewById(R.id.txt_morningdose);
        lunchdose=view.findViewById(R.id.txt_noondose);
        eveningdose=view.findViewById(R.id.txt_eveningdose);
        nightdose=view.findViewById(R.id.txt_nightdose);



        tvMedicineName.setText("" +medicineData.getMedication().getMedicineName());
//        tvMedicineEndDate.setText("End date:\n\n" +medicineData.getEndDate());
        MedicineData medicineData1=medicineData.getMedication();
//        morningdose.setText("" +medicineData1.getFrequencies());


//        Bundle bundle=new Bundle();
//        bundle.putString("medicinedata",medicineData.getEndDate());
//        Intent intent=new Intent(getContext(),MedicineEnddateHeader.class);
//        intent.putExtras(bundle);
//        startActivity(intent);



        return view;
    }
}
