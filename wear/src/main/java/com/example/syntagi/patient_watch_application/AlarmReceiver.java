package com.example.syntagi.patient_watch_application;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
       @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context, "ALARM ........", Toast.LENGTH_SHORT).show();
//            AlarmActivity inst=AlarmActivity.instance();
//            inst.setAlarmText("Alarm ! Wake Up !Wake Up");
           Toast.makeText(context,"Medicine Time!!!!",Toast.LENGTH_LONG).show();
           Log.w("AlarmReceiver","Alarm successfully set");
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Vibrator v= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
            v.vibrate(20000);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        if (ringtone!=null){
            ringtone.play();
        }
//
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//
//            context.startForegroundService(new Intent(context,AlarmService.class));
//        }
//        else {
//            context.startService(new Intent(context,AlarmService.class));
//        }
           Intent  intent1 = new Intent(context,AlarmService.class);
           if (intent1!=null){
               Log.d("AlarmService","start service ");
               context.startService(intent1);
           }
           else {
               context.stopService(intent1);
           }
    }
}
