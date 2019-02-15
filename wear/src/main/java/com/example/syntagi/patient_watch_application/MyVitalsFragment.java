package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.medicine.CurrentMedicineResponse;
import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyVitalsFragment extends Fragment {
    ImageView  imageView;
    Retrofit retrofit=null;
    ApiInterface apiInterface=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.my_vitals,container,false);
      imageView= view.findViewById(R.id.iv_vitals);

//      imageView.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//            Intent intent=new Intent(getContext(),MyVitalList.class);
//            startActivity(intent);
//          }
//      });

        return view;
    }

    public void Vital()
    {

    }
}
