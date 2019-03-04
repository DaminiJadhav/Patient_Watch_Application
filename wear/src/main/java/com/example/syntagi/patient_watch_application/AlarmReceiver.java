package com.example.syntagi.patient_watch_application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
       @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "ALARM ........", Toast.LENGTH_SHORT).show();
//            AlarmActivity inst=AlarmActivity.instance();
//            inst.setAlarmText("Alarm ! Wake Up !Wake Up");


        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);


//           try {
//
//               mediaPlayer.setDataSource(context,alarmUri);
//               final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//               if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM)!=0){
//                   mediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
//                   mediaPlayer.setLooping(true);
//                   mediaPlayer.prepare();
//                   mediaPlayer.start();
//               }
//           } catch (IOException e) {
//               e.printStackTrace();
//           }

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
           Intent  intent1 = new Intent(context,AlarmService.class);
           if (intent1!=null){
               context.startService(intent1);
           }
           else {
               context.stopService(intent1);
           }

//           ComponentName componentName=new ComponentName(context.getPackageName(),AlarmService.class.getName());
//           startWakefulService(context, (intent.setComponent(componentName)));
//           setResultCode(Activity.RESULT_OK);

    }


}
