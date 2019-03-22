package com.example.syntagi.patient_watch_application;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.syntagi.patient_watch_application.models.PatientData;
import com.example.syntagi.patient_watch_application.models.vitals.VitalsModelResponse;
import com.google.gson.Gson;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class MyVitalsFragment extends Fragment {
    ImageView  imageView;
    FrameLayout frameLayout;
    LinearLayout linearLayout;
    TextView totalvitalcount;

    ProgressDialog progressDialog;

    private static final String  KEY_CONNECTIONS="Patient_Details";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view= inflater.inflate(R.layout.my_vitals,container,false);
         imageView= view.findViewById(R.id.iv_vitals);
         frameLayout=view.findViewById(R.id.lay_container);
         linearLayout=view.findViewById(R.id.ll_vital);
         totalvitalcount=view.findViewById(R.id.tv_vitalcount);

            SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
            String vitaljson=sharedPreferences.getString("VitalData","");
            Gson gson=new Gson();
            VitalsModelResponse vitalsModelResponse=gson.fromJson(vitaljson,VitalsModelResponse.class);
            if (vitalsModelResponse!=null){
                totalvitalcount.setText(" " + vitalsModelResponse.getData().size());
            }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressDialog=new ProgressDialog(getContext());
//                progressDialog.setMessage("Loading....");
//                progressDialog.show();
//                Log.w("MyVitalsFragment","onClick Called");
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                final String json = sharedPreferences.getString(KEY_CONNECTIONS,"");
                Gson gson = new Gson();
                PatientData patientData = gson.fromJson(json, PatientData.class);
                if (patientData!=null){
                    frameLayout.setVisibility(v.VISIBLE);
                    linearLayout.setVisibility(v.INVISIBLE);
                    getFragmentManager().beginTransaction().add(R.id.lay_container,VitalFragment.getInstance(patientData,totalvitalcount),getTag()).commit();
//                    Toast.makeText(getContext(),"Success",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
