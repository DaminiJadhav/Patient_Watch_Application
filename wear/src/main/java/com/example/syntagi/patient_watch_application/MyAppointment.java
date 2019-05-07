package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.PatientData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyAppointment extends AppCompatActivity {
ViewPager viewPager;
List<Fragment> fragments=new ArrayList<>();
private static final String KEY_CONNECTIONS = "Patient_Details";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment2);
        viewPager=findViewById(R.id.viewpager_appointment);
//        Toast.makeText(MyAppointment.this,"Success",Toast.LENGTH_LONG).show();

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(MyAppointment.this);
        String json=sharedPreferences.getString(KEY_CONNECTIONS,"");
        Gson gson=new Gson();
        PatientData patientData=gson.fromJson(json,PatientData.class);
        if (patientData!=null) {
            fragments.add(AppointmentFragment.getInstance(patientData));
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new Myadapter(fragmentManager));
    }

    class Myadapter extends FragmentPagerAdapter{

        public Myadapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}

