package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.notification.NotificationData;
import com.example.syntagi.patient_watch_application.models.notification.NotificationResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShowAllUserData extends AppCompatActivity implements CustomListAdapterInterface {
    ListView listView;
    List<NotificationData> userDetialList=new ArrayList<>();
    CustomListAdapter listAdapter;
NotificationResponse notificationResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user_data);
        listView=findViewById(R.id.lv_userNotificationDetails);

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(ShowAllUserData.this);
        String jsonData=sharedPreferences.getString("Notification_Key","");
        Gson gson=new Gson();
        notificationResponse=gson.fromJson(jsonData,NotificationResponse.class);
       if (notificationResponse!=null){

//           Toast.makeText(ShowAllUserData.this,"ALL User data successfully Pass",Toast.LENGTH_LONG).show();
       }
       else
       {
           Toast.makeText(ShowAllUserData.this,"Failed",Toast.LENGTH_LONG).show();
       }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, int resourceID, LayoutInflater inflater) {

        return null;
    }
}
