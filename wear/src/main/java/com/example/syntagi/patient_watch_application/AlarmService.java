package com.example.syntagi.patient_watch_application;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Wake Up! Wake Up!");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmService", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, AlarmActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder alamNotificationBuilder=new NotificationCompat.Builder(this,"channel_id")
                .setContentTitle("Alarm").setSmallIcon(R.drawable.android)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg).setAutoCancel(true);

//        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
//                this).setContentTitle("Alarm").setSmallIcon(R.drawable.android)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
//                .setContentText(msg);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmService", "Notification sent.");
    }

//    @Override
//    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
////        return super.onStartCommand(intent, flags, startId);
//         palyer=MediaPlayer.create(this,R.raw.alarm_ring);
//        palyer.setLooping(true);
//        palyer.start();
//        return START_STICKY;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        palyer.stop();
//    }
}