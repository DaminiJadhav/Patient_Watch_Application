package com.example.syntagi.patient_watch_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.Model2.CurrentMedicines;
import com.example.syntagi.patient_watch_application.Model2.Data;
import com.google.android.gms.dynamic.IFragmentWrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyMedicine extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_medicine, container, false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://13.127.133.104:8082")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.medicine().enqueue(new Callback<CurrentMedicines>() {
            @Override
            public void onResponse(Call<CurrentMedicines> call, Response<CurrentMedicines> response) {
                if (response.isSuccessful()) {
                    CurrentMedicines currentMedicines = response.body();

                    if (currentMedicines.getError()){
                        Toast.makeText(getContext(), ""+currentMedicines.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getContext(), ""+currentMedicines.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "Code:"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentMedicines> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



}
