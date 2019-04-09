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

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.LoginData;
import com.example.syntagi.patient_watch_application.models.notification.NotificationData;
import com.example.syntagi.patient_watch_application.models.notification.NotificationResponse;
import com.example.syntagi.patient_watch_application.models.vitals.VitalsModelResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String USER_KEY ="Patient_Data" ;
    ImageView iv_notification;
    TextView notificationCount;
    LoginData loginData;
    ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();
    Retrofit retrofit;
    ApiInterface apiInterface;
    String getAllVitalData="http://13.127.133.104:8082";
    String getAllUserData="http://13.127.133.104:8082";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragments.add(new MyAppointmentFragment());
        fragments.add(new MyMedicineFragment());
        fragments.add(new MyVitalsFragment());

        notificationCount=findViewById(R.id.tv_notification_count);
        iv_notification=findViewById(R.id.iv_bell_icon);
        viewPager=findViewById(R.id.viewpager);

        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));

        iv_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,ShowAllUserData.class);
                startActivity(intent);
            }
        });

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        String json=sharedPreferences.getString(USER_KEY,"");
        Gson gson=new Gson();
        loginData=gson.fromJson(json,LoginData.class);
        if (loginData!=null)
        {
//            firstnametxt.setText("First Name:" +loginData.getPatientData().getFirstName());
//            phonenumbertxt.setText("Phone Number:" +loginData.getPatientData().getPhoneNumber());
//            firstnametxt.setText("User Id:" +loginData.getPatientData().getUpId());
        }

        getAllVital();
        getAllUserDetail(loginData.getPatientData().getPatientId());
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

    public void getAllUserDetail(String userId){
        retrofit=new Retrofit.Builder().baseUrl(getAllUserData)
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .build();
        apiInterface=retrofit.create(ApiInterface.class);
        apiInterface.getUserNotificationData(userId,loginData.getToken(),"2").enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                if (response.isSuccessful()) {
                    NotificationResponse notificationResponse = response.body();
                    if (notificationResponse.getError()){
                        Toast.makeText(HomeActivity.this,"" +notificationResponse.getMessage(),Toast.LENGTH_LONG).show();
                    }
                    if (notificationResponse != null) {
                        List<NotificationData> notificationData = notificationResponse.getData();
                        if (notificationData!=null){
                            notificationCount.setText("" +notificationData.size());
                        }
                    }
                    Gson gson = new Gson();
                    String json = gson.toJson(notificationResponse, NotificationResponse.class);
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this).edit();
                    editor.putString("Notification_Key", json);
                    editor.apply();
                } else {
                    Toast.makeText(HomeActivity.this, "Code" +response.message(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable t) {
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
