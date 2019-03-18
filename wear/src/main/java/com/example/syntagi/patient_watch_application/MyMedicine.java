package com.example.syntagi.patient_watch_application;

import android.Manifest;
import android.app.AlarmManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineFrequency;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import static android.content.Context.ALARM_SERVICE;

public class  MyMedicine extends Fragment {
    TextView reminder;
    ImageView iv_showmedicine,brkfast,lunch,eve,dinner;
    MedicationEndsOn medicineData;
    Switch aSwitch;
    AlarmManager alarmManager;
//    Uri uri;


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

        alarmManager= (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);


        tvMedicineEndDate = view.findViewById(R.id.tv_medicine_end_date);
        iv_showmedicine=view.findViewById(R.id.iv_showmedicineicon);
        tvMedicineName = view.findViewById(R.id.tv_medicine_name);
        morningdose=view.findViewById(R.id.txt_morningdose);
        lunchdose=view.findViewById(R.id.txt_noondose);
        eveningdose=view.findViewById(R.id.txt_eveningdose);
        nightdose=view.findViewById(R.id.txt_nightdose);
        reminder=view.findViewById(R.id.tv_reminder);
        brkfast=view.findViewById(R.id.iv_brkfast);
        lunch=view.findViewById(R.id.iv_lunch);
        eve=view.findViewById(R.id.iv_eve);
        dinner=view.findViewById(R.id.iv_dinner);
        aSwitch=view.findViewById(R.id.reminderswitch);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()){
                    Intent intent=new Intent(getContext(),AlarmActivity.class);
                    startActivity(intent);
           if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED){
//                        addReminderInCalender();
                        }
                }
                else {
                    Toast.makeText(getContext(), "Switch off", Toast.LENGTH_SHORT).show();

                }
            }
        });
        if (medicineData!=null){
            tvMedicineName.setText("" +medicineData.getMedication().getMedicineName());
            tvMedicineEndDate.setText("End date:  " +medicineData.getEndDate());
        }

        final MedicineData medicineData1=medicineData.getMedication();

        List<MedicineFrequency> medicineFrequencies=medicineData1.getFrequencies();

        for (int i=0;i<medicineFrequencies.size();i++)
        {
            if (medicineFrequencies.get(i).getMorningDose()>0){
                morningdose.setText("" +medicineFrequencies.get(i).getMorningDose());
                brkfast.setVisibility(View.VISIBLE);
            }
            else {
                brkfast.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }

            if (medicineFrequencies.get(i).getNoonDose()>0){
                lunchdose.setText("" +medicineFrequencies.get(i).getNoonDose());
                lunch.setVisibility(View.VISIBLE);
            }
            else {
                lunch.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }
            if (medicineFrequencies.get(i).getEveningDose()>0){
                eveningdose.setText("" +medicineFrequencies.get(i).getEveningDose());
            }
            else {
                eve.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }
            if (medicineFrequencies.get(i).getNightDose()>0){
                nightdose.setText("" +medicineFrequencies.get(i).getNightDose());
            }
            else {
                dinner.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }


        }

    iv_showmedicine.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MedicineDetailActivity.startActivity(MyMedicine.this,medicineData.getMedication());

        }
    });
        return view;
    }
    public void onstart(){
        onstart();
    }
}
