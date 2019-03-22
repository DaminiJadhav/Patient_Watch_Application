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

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.LoginData;
import com.example.syntagi.patient_watch_application.models.vitals.VitalsModelResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
        private static final String USER_KEY ="Patient_Data" ;
    TextView firstnametxt,phonenumbertxt;
    LoginData loginData;
    ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();
    Retrofit retrofit;
    ApiInterface apiInterface;
    String getAllVitalData="http://13.127.133.104:8082";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragments.add(new MyAppointmentFragment());
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

        getAllVital();
    }

    public void getAllVital(){
            retrofit=new Retrofit.Builder().baseUrl(getAllVitalData)
                                           .addConverterFactory(GsonConverterFactory.create())
                                           .build();
            apiInterface=retrofit.create(ApiInterface.class);
            apiInterface.getAllVitals("12345678","4").enqueue(new Callback<VitalsModelResponse>() {
                @Override
                public void onResponse(Call<VitalsModelResponse> call, Response<VitalsModelResponse> response) {
                    if (response.isSuccessful()){
                        VitalsModelResponse vitalsModelResponse=response.body();
                        if (vitalsModelResponse != null) {
                           Vital vital= (Vital) vitalsModelResponse.getData();
                           vitalsModelResponse.save(getApplicationContext());

                                    Gson gson=new Gson();
                                    SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(HomeActivity.this).edit();
                                    String json=gson.toJson(vitalsModelResponse,VitalsModelResponse.class);
                                    editor.putString("VitalData",json);
                                    editor.apply();
                        }
                            if (vitalsModelResponse.getError()){
                            Toast.makeText(HomeActivity.this,"" +vitalsModelResponse.getMessage(),Toast.LENGTH_LONG).show();
                        }

//                        Toast.makeText(HomeActivity.this,"Vital Response Success",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(HomeActivity.this,"Code" +response.code(),Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<VitalsModelResponse> call, Throwable t) {
                        Toast.makeText(HomeActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            });
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
            return 3;
        }
    }
}
