package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineFrequency;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class  MyMedicine extends Fragment {
    ImageView iv_showmedicine;
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
        tvMedicineEndDate = view.findViewById(R.id.tv_medicine_end_date);

        iv_showmedicine=view.findViewById(R.id.iv_showmedicineicon);
        tvMedicineName = view.findViewById(R.id.tv_medicine_name);
        morningdose=view.findViewById(R.id.txt_morningdose);
        lunchdose=view.findViewById(R.id.txt_noondose);
        eveningdose=view.findViewById(R.id.txt_eveningdose);
        nightdose=view.findViewById(R.id.txt_nightdose);

        tvMedicineName.setText("" +medicineData.getMedication().getMedicineName());
        tvMedicineEndDate.setText("End date:  " +medicineData.getEndDate());
        final MedicineData medicineData1=medicineData.getMedication();


        List<MedicineFrequency> medicineFrequencies=medicineData1.getFrequencies();
                for (int i=0;i<medicineFrequencies.size();i++)
        {

            morningdose.setText("" +medicineFrequencies.get(i).getMorningDose());
            lunchdose.setText("" +medicineFrequencies.get(i).getNoonDose());
            eveningdose.setText("" +medicineFrequencies.get(i).getEveningDose());
            nightdose.setText("" +medicineFrequencies.get(i).getNightDose());

        }

    iv_showmedicine.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MedicineDetailActivity.startActivity(MyMedicine.this,medicineData.getMedication());

        }
    });



//        Bundle bundle=new Bundle();
//        bundle.putString("medicinedata",medicineData.getEndDate());
//        Intent intent=new Intent(getContext(),MedicineEnddateHeader.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
        return view;
    }
}
