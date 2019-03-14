package com.example.syntagi.patient_watch_application;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.Ringtone;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.charting.formatter.IFillFormatter;
import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineDetailData;
import com.google.gson.Gson;

import java.util.Map;

import androidx.core.app.NotificationCompat;

public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;
    GetMedicineData getMedicineData;
    MedicationEndsOn medicineData;
    String medicineName;
    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
//        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(AlarmService.this);
//        String json=sharedPreferences.getString("Medicine","");
//        if (!TextUtils.isEmpty(json)){
//                Gson gson=new Gson();
//                getMedicineData=gson.fromJson(json,GetMedicineData.class);
//                medicationEndsOnMap=getMedicineData.getCurrentMedicines();
//                medicineName= medicationEndsOnMap.get(1).getMedication().getMedicineName();
//                Toast.makeText(AlarmService.this,"Medicine Name :" +medicineName,Toast.LENGTH_LONG).show();
//        }


        sendNotification("Wake Up! Wake Up!");
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