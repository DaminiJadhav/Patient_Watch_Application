package com.example.syntagi.patient_watch_application;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.syntagi.patient_watch_application.models.PatientData;
import com.example.syntagi.patient_watch_application.models.appointments.AppointmentListResponse;
import com.google.gson.Gson;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyAppointmentFragment extends Fragment {
    TextView textView;
    ImageView appointment_imgview;
    LinearLayout linearLayout;
    FrameLayout frameLayout;
    AppointmentListResponse appointmentListResponse=null;
    private static final String KEY_CONNECTIONS = "Patient_Details";
    private static final String KEY_APPOINTMENT="AppointmentData";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_appointment,container,false);
        appointment_imgview=view.findViewById(R.id.iv_appointment);
        linearLayout=view.findViewById(R.id.ll_appointment);
        frameLayout=view.findViewById(R.id.framelayout_appointment);
        textView=view.findViewById(R.id.tv_appointmentcount);

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
        String json=sharedPreferences.getString(KEY_APPOINTMENT,"");
        Gson gson=new Gson();
        appointmentListResponse=gson.fromJson(json,AppointmentListResponse.class);
        if (appointmentListResponse!=null){
            int count = appointmentListResponse.getData().size();
            textView.setText(count+ "");
         }


        appointment_imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
                String json=sharedPreferences.getString(KEY_CONNECTIONS,"");
                Gson gson=new Gson();
                PatientData patientData=gson.fromJson(json,PatientData.class);
                if (patientData!=null){
                    Log.i("MyAppointmentFragment","Successfully send patient data");
//                    Toast.makeText(getContext(),""+patientData.getPatientId(),Toast.LENGTH_LONG).show();
                    linearLayout.setVisibility(View.INVISIBLE);
                    frameLayout.setVisibility(View.VISIBLE);
                    getFragmentManager().beginTransaction().add(R.id.framelayout_appointment,AppointmentFragment.getInstance(patientData)).commit();

                }
            }
        });
        return view;
    }
}
