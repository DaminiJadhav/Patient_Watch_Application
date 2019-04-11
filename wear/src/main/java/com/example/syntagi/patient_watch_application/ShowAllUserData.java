package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.notification.NotificationData;
import com.example.syntagi.patient_watch_application.models.notification.NotificationResponse;
import com.example.syntagi.patient_watch_application.utils.CustomDateUtils;
import com.google.android.gms.common.util.DataUtils;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ShowAllUserData extends AppCompatActivity implements CustomListAdapterInterface {
    ListView listView;
    List<NotificationData> userDataList = new ArrayList<>();
    CustomListAdapter listAdapter;
    NotificationResponse notificationResponse=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_user_data);
        listView = findViewById(R.id.lv_userNotificationDetails);
        listAdapter = new CustomListAdapter(ShowAllUserData.this, R.layout.row_user_notification_details, userDataList, this);
        listView.setAdapter(listAdapter);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ShowAllUserData.this);
        String jsonData = sharedPreferences.getString("Notification_Key", "");
        Gson gson = new Gson();
        notificationResponse = gson.fromJson(jsonData, NotificationResponse.class);
        if (notificationResponse != null) {
//            Toast.makeText(ShowAllUserData.this,"Notification Added Successfully",Toast.LENGTH_LONG);
            userDataList.addAll(notificationResponse.getData());
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, int resourceID, LayoutInflater inflater) {
        AdapterHolder adapterHolder;
        if (convertView == null) {
            convertView = inflater.inflate(resourceID, parent, false);
            adapterHolder = new AdapterHolder(convertView);
            convertView.setTag(adapterHolder);
        } else {
            adapterHolder = (AdapterHolder) convertView.getTag();
        }
        NotificationData notificationData = userDataList.get(position);
        if (notificationData != null) {
// /           Toast.makeText(ShowAllUserData.this,"success",Toast.LENGTH_LONG).show();
            adapterHolder.tvUserDescription.setText("" + notificationData.getDescription());
            adapterHolder.tvdate.setText(CustomDateUtils.convertCreated(notificationData.getCreated()));
        }
        return convertView;
    }

    class AdapterHolder {
        private TextView tvUserDescription, tvdate;

        public AdapterHolder(View view) {
            tvUserDescription = view.findViewById(R.id.tv_user_description);
            tvdate = view.findViewById(R.id.tv_user_date);
        }
    }

   }
