package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Model1.LoginData;
import com.google.gson.Gson;

import java.util.Timer;
import java.util.TimerTask;

public class FirstPage extends AppCompatActivity {

    private static final String USER_KEY ="Patient_Data" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);



            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(FirstPage.this);
                    String json=sharedPreferences.getString(USER_KEY,"N/A");
                    Gson gson=new Gson();
                    LoginData loginData=gson.fromJson(json,LoginData.class);
                    if (loginData!=null)
                    {
                       // Toast.makeText(FirstPage.this, ""+loginData.getPatientData().getPhoneNumber(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(FirstPage.this,EnterPhoneNumberActivity.class);
                        startActivity(intent);
                    }
//                    else {
//                        Intent intent=new Intent(FirstPage.this,HomeActivity.class);
//                        startActivity(intent);
//                    }
                    finish();
                }
            },3000);
//        }
    }
}
