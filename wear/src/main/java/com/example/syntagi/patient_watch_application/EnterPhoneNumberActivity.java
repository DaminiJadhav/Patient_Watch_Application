package com.example.syntagi.patient_watch_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.LoginData;
import com.example.syntagi.patient_watch_application.models.LoginResponse;
import com.example.syntagi.patient_watch_application.models.PatientData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EnterPhoneNumberActivity extends WearableActivity {
//    7291847440
//    7709235373
//    9673959535
    private static final String USER_KEY = "Patient_Data";
    private static final String  KEY_CONNECTIONS="Patient_Details";
    TextInputLayout textInputLayout;
    TextInputEditText phone_no_ed;
    Button btn;

    private Retrofit retrofit = null;
    private ApiInterface apiInterface = null;
    private static final String phone_no_pattern = "[789][0-9]{9}";
    private Pattern pattern = Pattern.compile(phone_no_pattern);
    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone__num_activity);
        textInputLayout = findViewById(R.id.textinput_layout);
        phone_no_ed = findViewById(R.id.phone_ed_txt);
        btn = findViewById(R.id.generate_opt_btn);

        // Enables Always-on
        setAmbientEnabled();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation()) {
                        final String number = phone_no_ed.getText().toString().trim();

                        retrofit = new Retrofit.Builder().baseUrl("http://13.127.133.104:8082")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        apiInterface = retrofit.create(ApiInterface.class);
                        sendPost(number);

                }
            }
        });
    }

    public boolean Validation() {
        String ph_no = phone_no_ed.getText().toString();
        if (TextUtils.isEmpty(ph_no)) {
            textInputLayout.setError(getString(R.string.empty_phone_no));
            return false;
        } else if (!ph_no.matches(phone_no_pattern)) {
            textInputLayout.setError(getString(R.string.invalid_phone_no));
            return false;
        } else {
            textInputLayout.setError(null);
        }
        return true;
    }

    public void sendPost(String phone_number) {
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(EnterPhoneNumberActivity.this);
        progressDoalog.setMessage("Loading....");
        // show it
        progressDoalog.show();
        final Post post = new Post();
        post.setPhone_number(phone_number);
        apiInterface.getpost(post).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.getError()) {
                           Toast.makeText(EnterPhoneNumberActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                           progressDoalog.dismiss();
                           return;
                    }
                    LoginData loginResponseData = loginResponse.getData();
                    PatientData patientData = loginResponseData.getPatientData();

                    Gson gson=new Gson();
                    String JsonStr=gson.toJson(loginResponseData,LoginData.class);
                    String JsonStrData=gson.toJson(patientData,PatientData.class);
                    SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(EnterPhoneNumberActivity.this).edit();
                    editor.putString(USER_KEY,JsonStr);
                    editor.putString(KEY_CONNECTIONS, JsonStrData);
                    editor.apply();



                    if (patientData != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("PhoneNumber", phone_no_ed.getText().toString().trim());
//                        bundle.p  utSerializable("Patient_Data",patientData);
                        Intent intent = new Intent(EnterPhoneNumberActivity.this, OtpActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        progressDoalog.dismiss();
                    }

//                    Gson gson1=new Gson();
//                    String jsonStrData1=gson1.toJson(patientData,PatientData.class);
//                    SharedPreferences.Editor editor1= PreferenceManager.getDefaultSharedPreferences(EnterPhoneNumberActivity.this).edit();
//                    editor1.putString(KEY_CONNECTIONS,jsonStrData1);
//                    editor1.apply();

                } else {
                    Toast.makeText(EnterPhoneNumberActivity.this, "code is" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(EnterPhoneNumberActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                progressDoalog.dismiss();

            }
        });
    }

}
