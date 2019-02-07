package com.example.syntagi.patient_watch_application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.Model1.OtpResponse;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class OtpActivity extends AppCompatActivity {
    private static final String USER_KEY = "Patient_Data";

    Button verify_btn;
    TextInputLayout otp_input_layout;
    TextInputEditText otp_ed_txt;

    private Retrofit retrofit = null;
    private ApiInterface apiInterface = null;
    private String phoneNumber;
    String type_of_phone_number = "phone";

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Intent intent=this.getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            phoneNumber = bundle.getString("PhoneNumber");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification1);
        verify_btn = findViewById(R.id.verify_otp_btn1);
        otp_input_layout = findViewById(R.id.otp_txt);
        otp_ed_txt = findViewById(R.id.otp_ed_txt);

           verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (otp_validation()) {
                    final ProgressDialog progressDoalog;
                    progressDoalog = new ProgressDialog(OtpActivity.this);
                    progressDoalog.setMessage("Loading....");
                    // show it
                    progressDoalog.show();

                    final String otp_number = otp_ed_txt.getText().toString().trim();

                    retrofit = new Retrofit.Builder().baseUrl("http://13.127.133.104:8082")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    apiInterface = retrofit.create(ApiInterface.class);
                    apiInterface.varify_otp(type_of_phone_number, phoneNumber, otp_number).enqueue(new Callback<OtpResponse>() {
                        @Override
                        public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {

                            if (response.isSuccessful()) {
                                OtpResponse otpResponse = response.body();

                                if (otpResponse.getError())
                                {
                                    Toast.makeText(OtpActivity.this, ""+otpResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    progressDoalog.dismiss();

                                }
                                if (!otpResponse.getError()) {
                                    Toast.makeText(OtpActivity.this, "" + otpResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(OtpActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    progressDoalog.dismiss();
                                }

                            } else {
                                Toast.makeText(OtpActivity.this, "Code is " + response.code(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<OtpResponse> call, Throwable t) {
                            Toast.makeText(OtpActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                            progressDoalog.dismiss();
                        }
                    });

                }
            }

        });
    }
    public boolean otp_validation() {
        if (TextUtils.isEmpty(otp_ed_txt.getText().toString().trim())) {
            otp_input_layout.setError(getString(R.string.empty_otp_no));
            return false;
        }
        return true;
   }
}
