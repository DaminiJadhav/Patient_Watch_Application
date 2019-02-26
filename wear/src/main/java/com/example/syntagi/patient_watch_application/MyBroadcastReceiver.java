package com.example.syntagi.patient_watch_application;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

import static androidx.legacy.content.WakefulBroadcastReceiver.startWakefulService;
import static com.example.syntagi.patient_watch_application.R.*;

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
       @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "ALARM ........", Toast.LENGTH_SHORT).show();
//            AlarmActivity inst=AlarmActivity.instance();
//            inst.setAlarmText("Alarm ! Wake Up !Wake Up");



//           mediaPlayer=new MediaPlayer();
//           try {
//               mediaPlayer.setDataSource("alarm_ring.mp3");
//               mediaPlayer.prepare();
//               mediaPlayer.start();
//           }
//           catch (Exception e){
//               e.printStackTrace();
//           }
        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
//          mediaPlayer=MediaPlayer.create(this,raw.alarm_ring);
//             mediaPlayer.start();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Vibrator v= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
            v.vibrate(10000);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        if (ringtone!=null){
            ringtone.play();

        }

           ComponentName componentName=new ComponentName(context.getPackageName(),AlarmService.class.getName());
           startWakefulService(context, (intent.setComponent(componentName)));
           setResultCode(Activity.RESULT_OK);

    }

}
