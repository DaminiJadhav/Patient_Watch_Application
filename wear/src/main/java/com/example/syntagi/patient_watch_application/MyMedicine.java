package com.example.syntagi.patient_watch_application;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.enum_package.Reminder;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineFrequency;
import com.example.syntagi.patient_watch_application.utils.CustomDateUtils;

import java.util.Calendar;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.ALARM_SERVICE;

public class  MyMedicine extends Fragment {
    private static final long REPEAT_TIME=10000;
    TextView reminder,tv_morningtime,tv_lunchtime,tv_evetime,tv_dinnertime;
    ImageView iv_showmedicine,brkfast,lunch,eve,dinner;
    MedicationEndsOn medicationEndsOn;
    List<MedicineFrequency> medicineFrequencies;
    Switch aSwitch;
    AlarmManager alarmManager;
    Bundle bundle;


    public static MyMedicine getInstance(MedicationEndsOn medicineData) {
        MyMedicine myMedicine=new MyMedicine();
        myMedicine.medicationEndsOn = medicineData;
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
        tv_morningtime=view.findViewById(R.id.txt_morningtime);
        tv_lunchtime=view.findViewById(R.id.txt_lunchtime);
        tv_evetime=view.findViewById(R.id.txt_noontime);
        tv_dinnertime=view.findViewById(R.id.txt_nighttime);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()){
                    starttime();
                    DatabaseHandler databaseHandler=new DatabaseHandler(getContext());
                    databaseHandler.addmedicine(medicationEndsOn.getMedication(),Reminder.MOR);
//                    databaseHandler.getAllMedicineData();
                    databaseHandler.getAllData();
                    databaseHandler.deleteRow();
//                   ReminderActivity.startReminderActivity(MyMedicine.this, medicationEndsOn.getMedication() );
                }
                else {
                    Toast.makeText(getContext(), "Switch off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (medicationEndsOn !=null){
            tvMedicineName.setText("" + medicationEndsOn.getMedication().getMedicineName());
            tvMedicineEndDate.setText("End date:  " + medicationEndsOn.getEndDate());
        }

        final MedicineData medicineData1= medicationEndsOn.getMedication();

       medicineFrequencies=medicineData1.getFrequencies();

//        Reminder medicine_reminder = Reminder.findById(medicineData1.getReminderId());
//        String time = medicine_reminder.getTime();
        for (int i=0;i<medicineFrequencies.size();i++)
        {
            if (medicineFrequencies.get(i).getMorningDose()>0){
                morningdose.setText("" +medicineFrequencies.get(i).getMorningDose());
                tv_morningtime.setText(Reminder.MOR.getTime());
                brkfast.setVisibility(View.VISIBLE);
                reminder.setVisibility(View.VISIBLE);
                aSwitch.setVisibility(View.VISIBLE);
            }
            else {
                brkfast.setVisibility(View.INVISIBLE);
                this.reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }

            if (medicineFrequencies.get(i).getNoonDose()>0){
                lunchdose.setText("" +medicineFrequencies.get(i).getNoonDose());
                tv_lunchtime.setText(Reminder.NOON.getTime());
                lunch.setVisibility(View.VISIBLE);
                reminder.setVisibility(View.VISIBLE);
                aSwitch.setVisibility(View.VISIBLE);
            }
            else {
                lunch.setVisibility(View.INVISIBLE);
                this.reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }
            if (medicineFrequencies.get(i).getEveningDose()>0){
                eveningdose.setText("" +medicineFrequencies.get(i).getEveningDose());
                tv_evetime.setText(Reminder.EVE.getTime());
                eve.setVisibility(View.VISIBLE);
                reminder.setVisibility(View.VISIBLE);
                aSwitch.setVisibility(View.VISIBLE);
            }
            else {
                eve.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }
            if (medicineFrequencies.get(i).getNightDose()>0){
                nightdose.setText("" +medicineFrequencies.get(i).getNightDose());
                tv_dinnertime.setText(Reminder.NIGHT.getTime());
//                Toast.makeText(getContext(),""+Reminder.NIGHT.getTime(),Toast.LENGTH_LONG).show();
                dinner.setVisibility(View.VISIBLE);
                reminder.setVisibility(View.VISIBLE);
                aSwitch.setVisibility(View.VISIBLE);
            }
            else {
                dinner.setVisibility(View.INVISIBLE);
                reminder.setVisibility(View.INVISIBLE);
                aSwitch.setVisibility(View.INVISIBLE);
            }
        }
    iv_showmedicine.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MedicineDetailActivity.startActivity(MyMedicine.this, medicationEndsOn.getMedication());
        }
    });
        return view;
    }

    public void starttime(){
    for (MedicineFrequency freq:medicineFrequencies ){
        if (freq.isMorning()){
            Calendar calendar=Reminder.getCalender(Reminder.MOR.getTime());
            Intent intent=new Intent(getContext(),AlarmReceiver.class);
            int _id = Integer.parseInt(CustomDateUtils.convertDateFormat(Reminder.MOR.getTime(), CustomDateUtils.REMINDER_TIME_FORMAT,CustomDateUtils.REMINDER_ID_FORMAT));
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), _id, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent);
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), DateUtils.DAY_IN_MILLIS, pendingIntent);
            }
            if (freq.isNoon()){
                Calendar calendar=Reminder.getCalender(Reminder.NOON.getTime());
                Intent intent=new Intent(getContext(),AlarmReceiver.class);
                int _id = Integer.parseInt(CustomDateUtils.convertDateFormat(Reminder.NOON.getTime(), CustomDateUtils.REMINDER_TIME_FORMAT,CustomDateUtils.REMINDER_ID_FORMAT));
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), _id, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), DateUtils.DAY_IN_MILLIS, pendingIntent);
            }
            if (freq.isEvening()){
                Calendar calendar=Reminder.getCalender(Reminder.EVE.getTime());
                Intent intent=new Intent(getContext(),AlarmReceiver.class);
                int _id = Integer.parseInt(CustomDateUtils.convertDateFormat(Reminder.EVE.getTime(), CustomDateUtils.REMINDER_TIME_FORMAT,CustomDateUtils.REMINDER_ID_FORMAT));
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), _id, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), DateUtils.DAY_IN_MILLIS, pendingIntent);
            }
           if (freq.isNight()){
               Calendar calendar=Reminder.getCalender(Reminder.NIGHT.getTime());
               Intent intent=new Intent(getContext(),AlarmReceiver.class);
               int _id = Integer.parseInt(CustomDateUtils.convertDateFormat(Reminder.NIGHT.getTime(), CustomDateUtils.REMINDER_TIME_FORMAT,CustomDateUtils.REMINDER_ID_FORMAT));
               PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), _id, intent, 0);
               AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);
               alarmManager.cancel(pendingIntent);
               alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), DateUtils.DAY_IN_MILLIS, pendingIntent);

           }
        }
    }


    public void onstart(){
        onstart();
    }
}
