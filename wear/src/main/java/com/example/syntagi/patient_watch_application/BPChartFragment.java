package com.example.syntagi.patient_watch_application;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.syntagi.patient_watch_application.charting.charts.CombinedChart;
import com.example.syntagi.patient_watch_application.charting.data.Entry;
import com.example.syntagi.patient_watch_application.charting.data.LineDataSet;
import com.example.syntagi.patient_watch_application.models.vitals.GroupedVitalChartData;

import com.google.android.gms.common.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class BPChartFragment extends Fragment implements GraphUtil.GraphListener {

    private List<GroupedVitalChartData> dataList;
    private Vital vital;
    private GraphUtil graphUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_custom_graph,container,false);
        initViews(view);
        return view;
    }

    public static Fragment getInstance(List<GroupedVitalChartData> dataList, Vital vital) {
        BPChartFragment BPChartFragment = new BPChartFragment();
        BPChartFragment.dataList = dataList;
        BPChartFragment.vital = vital;
       return BPChartFragment;
    }


    public void initViews(View view) {
        CombinedChart combinedChart = view.findViewById(R.id.web_view);

        graphUtil=new GraphUtil(combinedChart,getContext(),this);
        setDataList(dataList);
    }

    private void setDataList(List<GroupedVitalChartData> data) {
        if(!CollectionUtils.isEmpty(data)){
            ArrayList<Entry> candleEntryArrayListOpen = new ArrayList<>();
            ArrayList<Entry> candleEntryArrayListClose = new ArrayList<>();
            for(int x=1;x<=data.size();x++){
                GroupedVitalChartData vitalChartData = data.get(x - 1);
                if(vitalChartData.getBpSystolic()!=0f){
                    candleEntryArrayListOpen.add(new Entry(x, (int) vitalChartData.getBpSystolic()));
                }
                if(vitalChartData.getBpDiastolic()!=0f){
                    candleEntryArrayListClose.add(new Entry(x, (int) vitalChartData.getBpDiastolic()));
                }
            }
            graphUtil.addLineGraph(candleEntryArrayListOpen,"B.P(Systolic)", ContextCompat.getColor(getContext(),R.color.color_pulse_rate), LineDataSet.Mode.CUBIC_BEZIER);
            graphUtil.addLineGraph(candleEntryArrayListClose,"B.P(Systolic)", ContextCompat.getColor(getContext(),R.color.color_body_weight), LineDataSet.Mode.CUBIC_BEZIER);
        }
        graphUtil.invalidateGraph();
    }



    @Override
    public String getTitle(float position) {
        if ((position - 1) < dataList.size()) {
            GroupedVitalChartData vitalChartData = dataList.get((int) position - 1);
            return vitalChartData.getxValue();
        }
        return "";
    }
}