package com.example.syntagi.patient_watch_application;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.google.gson.Gson;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;
    MedicineData medicineData;
    String CHANNEL_ID ="channel_id";
    String medicinename;
    Bundle bundle;
    public AlarmService() {
        super("AlarmService");
    }
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
//        Log.i("AlarmService", "onStartCommand called!");


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AlarmService.this);
        String json = sharedPreferences.getString("getmedicinename", "");
        Gson gson = new Gson();
        medicineData = gson.fromJson(json, MedicineData.class);
        if (medicineData != null) {
            medicinename = medicineData.getMedicineName();
            Log.d("AlarmService","reminder notification ");
//            Toast.makeText(AlarmService.this,"Alarm Service Success get medicine name",Toast.LENGTH_LONG).show();
//            sendNotification(medicinename);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Medicine Time!!!!!");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Toast.makeText(AlarmService.this,"Alarm notification successfully",Toast.LENGTH_LONG).show();
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MyMedicine.class), PendingIntent.FLAG_UPDATE_CURRENT);


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.BASE){
            CharSequence name="my_channel";
            String Description="This is my channel";
            int importance=NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mchannel=new NotificationChannel(CHANNEL_ID,name,importance);
            mchannel.setDescription(Description);
            mchannel.enableLights(true);
            mchannel.setLightColor(Color.RED);
            mchannel.enableVibration(true);
            mchannel.setVibrationPattern(new long[]{100,200,300,400,500,400,300,200,400});
            alarmNotificationManager.createNotificationChannel(mchannel);
        }

        Uri soundUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.alarm_ring);
        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Reminder")
                .setSmallIcon(R.drawable.reminder)
                .setSound(soundUri, AudioManager.STREAM_NOTIFICATION)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg)
                .setAutoCancel(true);

        if (alarmNotificationManager!=null){
            Intent intent=new Intent(AlarmService.this,ShowReminderMedicineDetailActivity.class);
            startActivity(intent);
        }


        Log.i("AlarmService","Successfully Send Alarm ");
        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService", "Notification sent.");
    }

}