package com.example.syntagi.patient_watch_application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
       @Override
    public void onReceive(Context context, Intent intent) {

//           String morning=intent.getStringExtra("Morning");
//           Log.i("AlarmReceiver","Morning time = " +morning);
//
//           String noon=intent.getStringExtra("noon");
//           Log.i("AlarmReceiver","Noon time = " +noon);
//
//           String evening=intent.getStringExtra("evening");
//           Log.i("AlarmReceiver","Evening time = " +evening);

           String time=intent.getStringExtra("time");
           Log.i("AlarmReceiver","time = " +time);

           Toast.makeText(context,"Medicine Time!!!!",Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Vibrator v= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
            v.vibrate(20000);
        }

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//            ContextCompat.startForegroundService(context,new Intent(context,AlarmService.class));
            intent=new Intent(context,AlarmService.class);
//            intent.putExtra("Key_Morning",morning);
//            intent.putExtra("Key_Noon",noon);
//            intent.putExtra("Key_Evening",evening);
            intent.putExtra("ReminderTime",time);
            context.startForegroundService(intent);
            Log.i("AlarmReceiver","start Foreground service");
        }
        else {
            context.startService(intent);
            Log.i("AlarmReceiver","start service");
        }
//           Intent  intent1 = new Intent(context,AlarmService.class);
//           if (intent1!=null){
//               Log.d("AlarmService","start service ");
//               context.startService(intent1);
//           }
//           else {
//               context.stopService(intent1);
//           }
    }
}
