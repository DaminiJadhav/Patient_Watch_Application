package com.example.syntagi.patient_watch_application;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.PatientData;
import com.example.syntagi.patient_watch_application.models.appointments.AppointmentData;
import com.example.syntagi.patient_watch_application.models.appointments.AppointmentListResponse;
import com.example.syntagi.patient_watch_application.models.appointments.AppointmentStatus;
import com.example.syntagi.patient_watch_application.models.appointments.TimeSlot;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppointmentFragment extends Fragment implements CustomListAdapterInterface {
    PatientData patientData;
    ListView listView;
    CustomListAdapter listAdapter;
    int size;

    private static final String KEY_APPOINTMENT="AppointmentData";
    String getAppointmnetData="http://13.127.133.104:8082";
    Retrofit retrofit=null;
    ApiInterface apiInterface=null;
    List<AppointmentData> appointmentDataList = new ArrayList<>();
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_my_appointment,container,false);
        listView=view.findViewById(R.id.lv_appointment);
        if (patientData!=null){
            progressDialog=new ProgressDialog(getContext());
            progressDialog.setMessage("Loading....");
            progressDialog.show();
            getAppointmentDetail(patientData.getPatientId());
        }
        listAdapter = new CustomListAdapter(getContext(),R.layout.row_appointment_activity,appointmentDataList,this);
        listView.setAdapter(listAdapter);
        return view;
    }


    public static AppointmentFragment getInstance(PatientData patientData){
        AppointmentFragment appointmentFragment=new AppointmentFragment();
        appointmentFragment.patientData=patientData;
        return appointmentFragment;
    }

    public void getAppointmentDetail(String patientId){
        retrofit=new Retrofit.Builder().baseUrl(getAppointmnetData)
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .build();
        apiInterface=retrofit.create(ApiInterface.class);
        apiInterface.getAppointmentData(patientId,"12345678",4).enqueue(new Callback<AppointmentListResponse>() {
            @Override
            public void onResponse(Call<AppointmentListResponse> call, Response<AppointmentListResponse> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    AppointmentListResponse appointmentListResponse=response.body();
//                    appointmentDataList.clear();
                    if (appointmentListResponse.getError()) {
                        Toast.makeText(getContext(),""+appointmentListResponse.getMessage(),Toast.LENGTH_LONG).show();

                    }
                        if (!appointmentListResponse.getError()){
                    if(appointmentListResponse.getData()!=null){
                        Toast.makeText(getContext(),"Success",Toast.LENGTH_LONG).show();
                        appointmentDataList.addAll(appointmentListResponse.getData());
                        Log.w("AppointmentFragment","Appointment Save Successfully");

                        Gson gson=new Gson();
                        SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                        String json=gson.toJson(appointmentListResponse,AppointmentListResponse.class);
                        Log.d("AppointmentFragment","Save Json Data");
                        editor.putString(KEY_APPOINTMENT,json);
                        editor.apply();
//                        size=appointmentListResponse.getData().size();
//                        Toast.makeText(getContext(),"Size: " +size,Toast.LENGTH_LONG).show();
                    }
                    }
                    listAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<AppointmentListResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, int resourceID, LayoutInflater inflater) {
        Holder holder;
        if (convertView==null){
            convertView = inflater.inflate(resourceID,parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        AppointmentData appointmentData = appointmentDataList.get(position);
        holder.tvName.setText(appointmentData.getPatientData().getName()+" -> "+appointmentData.getPhysicianData().getProfile().getFullname());
        holder.tvDate.setText(convertDateFormat(appointmentData.getDate(),"dd-MM-yyyy","dd"));
        holder.tvMonth.setText(convertDateFormat(appointmentData.getDate(),"dd-MM-yyyy","MMM"));
        AppointmentStatus appointmentStatus = AppointmentStatus.findByCode(appointmentData.getAppointmentStatus());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(convertDateFormat(appointmentData.getDate(),"dd-MM-yyyy","EEEE"));
        stringBuilder.append(" ");
        TimeSlot timeSlot = appointmentData.getTimeSlot();
        if (timeSlot!=null){
            String startTime = timeSlot.getStartTime();
            if (startTime!=null){
                stringBuilder.append(startTime);
            }
        }
        stringBuilder.append("\n"+appointmentStatus.getTitle());
        holder.tvStatus.setText(stringBuilder);
        return convertView;
    }
    class Holder{
        private TextView tvName,tvStatus,tvDate,tvMonth;

        public Holder(View view) {
           tvName = view.findViewById(R.id.tv_appointmentname);
           tvStatus=view.findViewById(R.id.tv_appointmentstatus);
           tvMonth=view.findViewById(R.id.tv_month);
           tvDate=view.findViewById(R.id.tv_date);
       }
    }
    private static String convertDateFormat(String currentDate,
                                           String currentDateFormatString, String reqDateFormat) {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat(currentDateFormatString);
        SimpleDateFormat formater = new SimpleDateFormat(reqDateFormat);
        try {
            Date d=new Date();
            if (d!=null){
                d = currentDateFormat.parse(currentDate);
                return formater.format(d);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currentDate;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        progressDialog.dismiss();
        super.onSaveInstanceState(outState);
    }
}
