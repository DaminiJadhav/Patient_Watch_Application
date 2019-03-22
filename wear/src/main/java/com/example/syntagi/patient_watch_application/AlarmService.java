package com.example.syntagi.patient_watch_application;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
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
    String medicinename;

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

//            Toast.makeText(AlarmService.this,"Alarm Successfully Remind",Toast.LENGTH_LONG).show();
            sendNotification(medicinename);
        }
//        Toast.makeText(AlarmService.this,"Intent:"+intent+ "Flag" +flags+ "StartID" +startId,Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onHandleIntent(Intent intent) {

//        if (intent!=null){
//
//            Bundle bundle=intent.getExtras();
//            if (bundle!=null){
//                medicineData= (MedicineData) bundle.getSerializable("medicineDetails");
//                medicinename=medicineData.getMedicineName();
//                Toast.makeText(AlarmService.this,"Success",Toast.LENGTH_LONG).show();
//            }
//        }
//

//        sendNotification("Medicine Time!!!!");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, AlarmActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        Uri soundUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.alarm_ring);
        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(this, "channel_id")
                .setContentTitle("Reminder")
                .setSmallIcon(R.drawable.reminder)
                .setSound(soundUri, AudioManager.STREAM_NOTIFICATION)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg)
                .setAutoCancel(true);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
//        cancelNotification(AlarmService.this,1);
        Log.d("AlarmService", "Notification sent.");
    }

    public static void cancelNotification(Context context, int notifyId) {
        String cancelnotification = Context.NOTIFICATION_SERVICE;
        NotificationManager manager = (NotificationManager) context.getSystemService(cancelnotification);
        manager.cancel(notifyId);


    }
}