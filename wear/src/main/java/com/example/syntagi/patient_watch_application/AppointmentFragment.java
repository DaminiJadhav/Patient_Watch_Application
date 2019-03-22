package com.example.syntagi.patient_watch_application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.models.LoginData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFragment extends AppCompatActivity {
    ViewPager viewPager;
    String patientid;
    LoginData loginData;
    List<Fragment> fragments=new ArrayList<>();
    private static final String USER_KEY = "Patient_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_fragment);

        viewPager=findViewById(R.id.viewpager_appointment);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapterFragment(fragmentManager));

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(AppointmentFragment.this);
        String json=sharedPreferences.getString(USER_KEY,"");
        Gson gson=new Gson();
        loginData=gson.fromJson(json,LoginData.class);
        if (loginData!=null){
            patientid=loginData.getPatientData().getPatientId();
            Log.w("AppointmentFragment","Success");
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();

        }
    }
        class MyAdapterFragment extends FragmentPagerAdapter{

            public MyAdapterFragment(FragmentManager fm) {
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
