package com.example.syntagi.patient_watch_application;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmActivity extends AppCompatActivity {
    private static final long REPEAT_TIME =10000;
    TextView enddatetext,setreminder;
private static AlarmActivity inst;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    TimePicker alarmTimePicker;
    ToggleButton toggleButton;

    int mHour,mMin;

    public static AlarmActivity instance(){
        return inst;
    }

    @Override
    protected void onStart() {
        super.onStart();
        inst=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_enddate_header);
        setreminder=findViewById(R.id.tv_reminder);
        toggleButton=findViewById(R.id.toggleButton);
        alarmTimePicker=findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.alarm_ring);
        mediaPlayer.start();

        alarmTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour=hourOfDay;
                mMin=minute;
//                if (view==alarmTimePicker){
//                    startService(new Intent(AlarmActivity.this,AlarmService.class));
//                }
//                setreminder.setText(setreminder.getText().toString()+ ""+ mHour + ":" +mMin);
            }
        });

    }
    public void OnToggleClicked(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(AlarmActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar=Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getHour());
            calendar.set(Calendar.MINUTE,alarmTimePicker.getMinute());
            Intent intent=new Intent(this,MyBroadcastReceiver.class);
            pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
//            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            if (System.currentTimeMillis()>time){
                if (calendar.AM_PM==0){
                    time=time+(1000)*60*60*12;
                }
                else {
                    time=time+(1000)*60*60*24;
                }

            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,REPEAT_TIME,pendingIntent);
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,AlarmManager.INTERVAL_DAY,pendingIntent);
//            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),REPEAT_TIME,pendingIntent);
//            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),REPEAT_TIME,pendingIntent);
//            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),AlarmManager.INTERVAL_HALF_DAY,pendingIntent);

        }
        else {
            alarmManager.cancel(pendingIntent);
            setAlarmText("Alarm");
            Toast.makeText(this, "Alarm off", Toast.LENGTH_SHORT).show();
        }
    }
    public void setAlarmText(String alarmText){
        setreminder.setText(alarmText);
    }


}
