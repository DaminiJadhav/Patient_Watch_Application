package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.Interfaces.ApiInterface;
import com.example.syntagi.patient_watch_application.models.PatientData;
import com.example.syntagi.patient_watch_application.models.vitals.GroupedVitalChartData;
import com.example.syntagi.patient_watch_application.models.vitals.GroupedVitalChartResponse;
import com.example.syntagi.patient_watch_application.models.vitals.VitalChartData;
import com.example.syntagi.patient_watch_application.models.vitals.VitalsModelResponse;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VitalFragment extends Fragment implements CustomPagerAdapter.PagerAdapterInterface {
    PatientData patientData;
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CustomPagerAdapter pagerAdapter;
    private TextView tvVitalCount,vitaltxtdata;
    private ArrayList<GroupedVitalChartData> dataList = new ArrayList<>();

    Retrofit retrofit=null;
    ApiInterface apiInterface=null;
    String getVitalChatDataEntries="http://13.127.133.104:8082";



    public static VitalFragment myClickMethod(View v) {
        VitalFragment vitalFragment=new VitalFragment();
        return vitalFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_vital,container,false);
        tvVitalCount=view.findViewById(R.id.emptyView);
        vitaltxtdata=view.findViewById(R.id.tv_vitaldata);
        initViews(view);
        return view;
    }

    public static VitalFragment getInstance(PatientData patientData, TextView tvVitalCount) {
        VitalFragment vitalFragment = new VitalFragment();
        vitalFragment.patientData = patientData;
        vitalFragment.tvVitalCount = tvVitalCount;
        return vitalFragment;
    }

//    public static VitalFragment getInstance(PatientData patientData) {
//        VitalFragment vitalFragment = new VitalFragment();
//        return vitalFragment;
//    }


    public void initViews(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout_my_vital);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_my_vital);
        pagerAdapter = new CustomPagerAdapter(getChildFragmentManager(), tabs, this);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(6);
        if (patientData!=null){
            getVitalData(patientData.getPatientId());
        }
    }


    private void getVitalData(String patientId) {
        this.dataList.clear();
        getVitalsData(patientId);
        setPagerAdapter();
//        HttpParamObject httpParamObject = ApiRequestGenerator.getVitalData(patientId);
//        executeTask(AppConstants.TASK_CODES.GET_VITAL_CHART_DATA, httpParamObject);
    }

    private void setPagerAdapter() {
        tabs.clear();
        fragments.clear();
        boolean isBloodPressureExist = false;
        List<String> existVitals = new ArrayList<>();
        for (GroupedVitalChartData groupedVitalChartData : dataList) {
            if (groupedVitalChartData.getBpDiastolic() != 0f && groupedVitalChartData.getBpSystolic() != 0f) {
                isBloodPressureExist = true;
            }
            for (VitalChartData vitalChartData : groupedVitalChartData.getOtherList()) {
                if (vitalChartData.getValue() != null && !existVitals.contains(vitalChartData.getVitalId())) {
                    existVitals.add(vitalChartData.getVitalId());
                }
            }
        }
        if (isBloodPressureExist) {
            tabs.add("Blood Pressure");
            fragments.add(BPChartFragment.getInstance(dataList, VitalsModelResponse.getByName("B.P")));
        }
        VitalsModelResponse vitalsModelResponse = VitalsModelResponse.getSaved();
        if (vitalsModelResponse != null) {

            List<Vital> vitalList = vitalsModelResponse.getData();
            for (Vital vital : vitalList) {
                if (existVitals.contains(vital.getVitalId())) {
                    if (!vital.getShortCode().equals("B.P") && !vital.getVitalName().equals("Height") && !vital.getShortCode().equals("Weight")) {
                        tabs.add(vital.getVitalName());
                        fragments.add(VitalChartFragment.getInsatance(dataList, vital));
                    }
                }
            }
        }
        if (tvVitalCount!=null){
            tvVitalCount.setText(String.valueOf(fragments.size()));
        }
        viewPager.setAdapter(pagerAdapter);
        if (!CollectionUtils.isEmpty(fragments)) {
            hideVisibility(R.id.emptyView);
        } else {
            showVisibility(R.id.emptyView);
        }
    }

    private void showVisibility(int emptyView) {
//       tvVitalCount.setVisibility(View.VISIBLE);
    }

    private void hideVisibility(int emptyView) {
//        tvVitalCount.setVisibility(View.INVISIBLE);
    }


    @Override
    public Fragment getFragmentItem(int position, Object listItem) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position, Object listItem) {
        return tabs.get(position);
    }



    public void getVitalsData(String patientId){
        retrofit=new Retrofit.Builder().baseUrl(getVitalChatDataEntries)
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .build();
        apiInterface=retrofit.create(ApiInterface.class);
        apiInterface.getAllVitalData("weekly",patientId,"12345678","4").enqueue(new Callback<GroupedVitalChartResponse>() {
            @Override
            public void onResponse(Call<GroupedVitalChartResponse> call, Response<GroupedVitalChartResponse> response) {

                if (response.isSuccessful()){
                    GroupedVitalChartResponse groupedVitalChartResponse=response.body();

                      if (groupedVitalChartResponse.getError()){
                            Toast.makeText(getActivity(),"" +groupedVitalChartResponse.getMessage(),Toast.LENGTH_LONG).show();
                      }

                      List<GroupedVitalChartData> dataList=groupedVitalChartResponse.getData();
                      if (!CollectionUtils.isEmpty(dataList)){
                          dataList.addAll(dataList);
                          vitaltxtdata.setText("Vital Data : " +dataList.get(1).getxValue());
                      }
                        setPagerAdapter();
                    }
                else {
                    Toast.makeText(getActivity(),"Code" + response.code(),Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<GroupedVitalChartResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"Error" ,Toast.LENGTH_LONG).show();
            }
        });
    }


//    @Override
//    public void onPostExecute(Object response, int taskCode, Object... params) {
//        super.onPostExecute(response, taskCode, params);
//        switch (taskCode) {
//            case AppConstants.TASK_CODES.GET_VITAL_CHART_DATA:
//                this.dataList.clear();
//                GroupedVitalChartResponse groupedVitalChartResponse = (GroupedVitalChartResponse) response;
//                if (!groupedVitalChartResponse.getError()) {
//                    List<GroupedVitalChartData> dataList = groupedVitalChartResponse.getData();
//                    if (CollectionUtils.isNotEmpty(dataList)) {
//                        this.dataList.addAll(dataList);
//                    }
//                }
//                setPagerAdapter();
//
//        }
//    }

    public void refreshPatient(PatientData patientData) {
        this.patientData=patientData;
        getVitalData(patientData.getPatientId());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==getActivity().RESULT_OK){
            initViews(getView());
        }
    }


//    class myVitalAdapter extends FragmentPagerAdapter{
//
//        public myVitalAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            Fragment fragment=null;
//            if (position==0){
//                fragment=new VitalChartFragment();
//            }
//            return fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return 1;
//        }
//    }


}
