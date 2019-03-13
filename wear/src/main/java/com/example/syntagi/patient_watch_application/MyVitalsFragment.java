package com.example.syntagi.patient_watch_application;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.syntagi.patient_watch_application.models.PatientData;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MyVitalsFragment extends Fragment {

    ImageView  imageView;
    FrameLayout frameLayout;
    LinearLayout linearLayout;
    private static final String  KEY_CONNECTIONS="Patient_Details";
        Context context;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view= inflater.inflate(R.layout.my_vitals,container,false);
         imageView= view.findViewById(R.id.iv_vitals);
         frameLayout=view.findViewById(R.id.lay_container);
         linearLayout=view.findViewById(R.id.ll_vital);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                final String json = sharedPreferences.getString(KEY_CONNECTIONS,"");
                Gson gson = new Gson();
                PatientData patientData = gson.fromJson(json, PatientData.class);
                if (patientData!=null){
//                    Toast.makeText(getContext(),"Success",Toast.LENGTH_SHORT).show();
                }
                else {
//                    Toast.makeText(getContext(),"Patient Data Null",Toast.LENGTH_LONG).show();
                }

                frameLayout.setVisibility(v.VISIBLE);
                linearLayout.setVisibility(v.INVISIBLE);
                getFragmentManager().beginTransaction().add(R.id.lay_container,VitalFragment.getInstance(patientData,null),getTag()).commit();
            }
        });
        return view;
    }

    private Bundle getIntent() {
        return null;
    }

}
