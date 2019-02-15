package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.example.syntagi.patient_watch_application.models.LoginData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
        private static final String USER_KEY ="Patient_Data" ;
    TextView firstnametxt,phonenumbertxt;
    LoginData loginData;
    ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragments.add(new MyMedicineFragment());
        fragments.add(new MyVitalsFragment());

        firstnametxt = findViewById(R.id.json_data_txt);
        phonenumbertxt=findViewById(R.id.json_data_txt2);
        viewPager=findViewById(R.id.viewpager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));



        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        String json=sharedPreferences.getString(USER_KEY,"");
        Gson gson=new Gson();
        loginData=gson.fromJson(json,LoginData.class);
        if (loginData!=null)
        {
            firstnametxt.setText("First Name:" +loginData.getPatientData().getFirstName());
            phonenumbertxt.setText("Phone Number:" +loginData.getPatientData().getPhoneNumber());
        }


    }



    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
