package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.LoginData;
import com.example.syntagi.patient_watch_application.models.medicine.CurrentMedicineResponse;
import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineFrequency;
import com.google.gson.Gson;
import java.util.Map;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyMedicineFragment extends Fragment {
    private static final String USER_KEY = "Patient_Data";
    private String patientId;
    ImageView imageView;
    TextView noofmedicine;

    Retrofit retrofit = null;
    ApiInterface apiInterface = null;
    GetMedicineData getMedicineData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_medicine, container, false);
        imageView = view.findViewById(R.id.iv_medicine);
        noofmedicine=view.findViewById(R.id.medicinecount);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String json = sharedPreferences.getString(USER_KEY, "");
        Gson gson = new Gson();
        LoginData loginData = gson.fromJson(json, LoginData.class);
        if (loginData != null) {
            patientId = loginData.getPatientData().getPatientId();
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MyMedicineList.class);
                startActivity(intent);
            }
        });

        medicineList(patientId);
        return view;
    }

    public void medicineList(String patientId) {
        retrofit = new Retrofit.Builder().baseUrl("http://13.127.133.104:8082")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.medicine(patientId, "12345678", 4).enqueue(new Callback<CurrentMedicineResponse>() {
            @Override
            public void onResponse(Call<CurrentMedicineResponse> call, Response<CurrentMedicineResponse> response) {
                if (response.isSuccessful()) {
                    CurrentMedicineResponse currentMedicineResponse = response.body();
                    if (currentMedicineResponse.getError()) {
                        Toast.makeText(getContext(), currentMedicineResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    GetMedicineData medicineData = currentMedicineResponse.getData();
                    if (medicineData != null) {
                        Map<String, MedicationEndsOn> medicationEndsOnMap = medicineData.getCurrentMedicines();
                        if (medicationEndsOnMap!=null){
                            noofmedicine.setText("" +medicationEndsOnMap.size());
                        }

                    }
                    Gson gson=new Gson();
                    String JsonStr=gson.toJson(medicineData,GetMedicineData.class);
                    SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                    editor.putString("Medicine",JsonStr);
                    editor.apply();
                } else {
                    Toast.makeText(getContext(), "Code is:" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CurrentMedicineResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
