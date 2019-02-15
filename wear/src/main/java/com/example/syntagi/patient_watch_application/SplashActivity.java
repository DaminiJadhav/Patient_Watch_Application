package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.LoginData;
import com.google.gson.Gson;

public class SplashActivity extends AppCompatActivity {
    LoginData loginData;
    private static final String USER_KEY = "Patient_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (checkLoggedin()) {
                    Toast.makeText(SplashActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this, EnterPhoneNumberActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);
    }

    public boolean checkLoggedin() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        String json = sharedPreferences.getString(USER_KEY, "");
        if (!TextUtils.isEmpty(json)) {
            Gson gson = new Gson();
            loginData = gson.fromJson(json, LoginData.class);
            if (loginData != null) {
//                Toast.makeText(SplashActivity.this,""+loginData.getPatientData().getPhoneNumber(),Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }
}
