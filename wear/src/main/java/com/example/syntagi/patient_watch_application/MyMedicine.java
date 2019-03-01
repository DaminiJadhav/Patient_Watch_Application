package com.example.syntagi.patient_watch_application;

import android.Manifest;
import android.app.AlarmManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
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

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import static android.content.Context.ALARM_SERVICE;

public class  MyMedicine extends Fragment {
    ImageView iv_showmedicine;
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

        tvMedicineName.setText("" +medicineData.getMedication().getMedicineName());
        tvMedicineEndDate.setText("End date:  " +medicineData.getEndDate());
        final MedicineData medicineData1=medicineData.getMedication();

        List<MedicineFrequency> medicineFrequencies=medicineData1.getFrequencies();

        for (int i=0;i<medicineFrequencies.size();i++)
        {
            if (medicineFrequencies.get(i).getMorningDose()>0){
                morningdose.setText("" +medicineFrequencies.get(i).getMorningDose());
            }
            if (medicineFrequencies.get(i).getNoonDose()>0){
                lunchdose.setText("" +medicineFrequencies.get(i).getNoonDose());
            }
            if (medicineFrequencies.get(i).getEveningDose()>0){
                eveningdose.setText("" +medicineFrequencies.get(i).getEveningDose());
            }
            if (medicineFrequencies.get(i).getNightDose()>0){
                nightdose.setText("" +medicineFrequencies.get(i).getNightDose());
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


    private void addReminderInCalender(){
        String eventUriString = "content://com.android.calendar/events";
        Calendar cal=Calendar.getInstance();
        Uri eventUri=Uri.parse(getCalenderUriBase(true) + "events");
        ContentResolver cr=getActivity().getContentResolver();
        TimeZone timeZone=TimeZone.getDefault();
        ContentValues values=new ContentValues();
        values.put(CalendarContract.Events.CALENDAR_ID,1);
        values.put(CalendarContract.Events.TITLE, "Reminder 01");
        values.put(CalendarContract.Events.DESCRIPTION, "A test Reminder.");
        values.put(CalendarContract.Events.ALL_DAY, 0);
        values.put(CalendarContract.Events.DTSTART, cal.getTimeInMillis() + 1 * 60 * 1000);
        values.put(CalendarContract.Events.DTEND, cal.getTimeInMillis() + 2 * 60 * 1000);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
        values.put(CalendarContract.Events.HAS_ALARM, 1);
        Uri uri=cr.insert(eventUri,values);
//        Uri uri=cr.insert(eventUri,values);
//        Uri uri=curactivity.getApplicationContext().getContentResolver().insert(Uri.parse(eventUriString),values);
        Toast.makeText(getContext(), "Event add-- ID ", Toast.LENGTH_SHORT).show();

        Uri reminderUri=Uri.parse(getCalenderUriBase(true) + "Reminder");
        values=new ContentValues();
        values.put(CalendarContract.Reminders.EVENT_ID,Long.parseLong(uri.getLastPathSegment()));
        values.put(CalendarContract.Reminders.METHOD,CalendarContract.Reminders.METHOD_ALERT);
        values.put(CalendarContract.Reminders.MINUTES,10);
        cr.insert(reminderUri,values);



    }
   public String getCalenderUriBase(boolean eventUri){
     Uri calenderUri=null;
     try{
         if (Build.VERSION.SDK_INT<=7){
             calenderUri=(eventUri) ? Uri.parse("content://calendar/") : Uri.parse("content://calendar/calendars");
         }
         else {
             calenderUri=(eventUri) ? Uri.parse("content://com.android.calendar/") : Uri.parse("content://com.android.calendar/calendars");
         }
     }catch (Exception e){
         e.printStackTrace();
     }
    return calenderUri.toString();
    }



    public void onstart(){
        onstart();
    }
}
