package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.Model1.LoginData;
import com.example.syntagi.patient_watch_application.Model1.LoginResponse;
import com.example.syntagi.patient_watch_application.Model1.OtpResponse;
import com.example.syntagi.patient_watch_application.Model2.CurrentMedicines;
import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {
        private static final String USER_KEY ="Patient_Data" ;
    TextView firstnametxt,phonenumbertxt;
    LoginData loginData;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firstnametxt = findViewById(R.id.json_data_txt);
        phonenumbertxt=findViewById(R.id.json_data_txt2);
        viewPager=findViewById(R.id.viewpager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));



        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        String json=sharedPreferences.getString(USER_KEY,"N/A");
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
            Fragment fragment=null;


            if (position==0)
            {
                fragment=new MyMedicine();
            }
            if (position==1)
            {
                fragment=new MyVitals();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
