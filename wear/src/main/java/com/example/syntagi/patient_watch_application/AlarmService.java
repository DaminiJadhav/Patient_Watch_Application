package com.example.syntagi.patient_watch_application;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;
    MedicineData medicineData;
    String medicineName;
    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        intent=this.getIntent();
        if (intent!=null){
            Bundle bundle=intent.getExtras();
            if (bundle!=null){
//                if (bundle.containsKey("NotifivationMessage"))
                medicineData= (MedicineData) bundle.getSerializable("medicineDetails");
                medicineName=medicineData.getMedicineName();
                Toast.makeText(AlarmService.this,"Medicine Name : " +medicineName,Toast.LENGTH_LONG).show();
                sendNotification(medicineName);
            }
        }

        return  super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Medicine Time !!!!");
    }

    private Intent getIntent() {
        return null;
    }


    private void sendNotification(String msg) {
        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, AlarmActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        Uri soundUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.alarm_ring);
        NotificationCompat.Builder alamNotificationBuilder=new NotificationCompat.Builder(this,"channel_id")
                                                                        .setContentTitle("Reminder")
                                                                        .setSmallIcon(R.drawable.reminder)
                                                                        .setSound(soundUri,AudioManager.STREAM_NOTIFICATION)
                                                                        .setVibrate(new long[] {1000,1000,1000,1000,1000})
                                                                        .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                                                                        .setContentText(msg)
                                                                        .setAutoCancel(true);



        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
//        cancelNotification(AlarmService.this,1);
        Log.d("AlarmService", "Notification sent.");
    }

    public static void cancelNotification(Context context,int notifyId){
        String cancelnotification=Context.NOTIFICATION_SERVICE;
        NotificationManager manager= (NotificationManager) context.getSystemService(cancelnotification);
        manager.cancel(notifyId);


    }
}