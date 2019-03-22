package com.example.syntagi.patient_watch_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.syntagi.patient_watch_application.charting.charts.CombinedChart;
import com.example.syntagi.patient_watch_application.charting.data.Entry;
import com.example.syntagi.patient_watch_application.charting.data.LineDataSet;
import com.example.syntagi.patient_watch_application.models.vitals.GroupedVitalChartData;
import com.example.syntagi.patient_watch_application.models.vitals.VitalChartData;

import com.google.android.gms.common.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class VitalChartFragment extends Fragment implements GraphUtil.GraphListener{
    private ArrayList<GroupedVitalChartData> dataList;
    private Vital vital;
    private GraphUtil graphUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candle_graph, container, false);
        initViews(view);
        return view;

    }

    public static VitalChartFragment getInsatance(ArrayList<GroupedVitalChartData> dataList, Vital vital) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstants.BUNDLE_KEYS.VITAL_DATA, vital);
        bundle.putSerializable(AppConstants.BUNDLE_KEYS.CHART_DATA_LIST, dataList);
        VitalChartFragment chartFragment = new VitalChartFragment();
        chartFragment.setArguments(bundle);
        return chartFragment;
    }

    public void initViews(View view) {

        Bundle arguments = getArguments();
        vital = (Vital) arguments.getSerializable(AppConstants.BUNDLE_KEYS.VITAL_DATA);
        dataList = (ArrayList<GroupedVitalChartData>) arguments.getSerializable(AppConstants.BUNDLE_KEYS.CHART_DATA_LIST);

        CombinedChart combinedChart = view.findViewById(R.id.web_view);
        graphUtil = new GraphUtil(combinedChart, getActivity(), this);
        setDataList(dataList);
    }

    private void setDataList(List<GroupedVitalChartData> data) {
        ArrayList<Entry> lineEntriesList = new ArrayList<>();
        if (data != null) {
            int x = 0;
            for (GroupedVitalChartData chartData : data) {
                List<VitalChartData> otherList = chartData.getOtherList();
                if (!CollectionUtils.isEmpty(otherList)) {
                    for (VitalChartData vitalChartData : otherList) {
                        if (vitalChartData.getVitalId().equals(vital.getVitalId())) {
                            lineEntriesList.add(new Entry(x++, (int) vitalChartData.getValue().floatValue()));
                            break;
                        }
                    }
                }
            }
        }
        int colorCode = ContextCompat.getColor(getContext(), R.color.color_accent);
        if (vital != null) {
            if (vital.getColorCode() != null) {
                colorCode = Color.parseColor(vital.getColorCode());
            }

            graphUtil.addLineGraph(lineEntriesList, vital.getVitalName(), colorCode, LineDataSet.Mode.CUBIC_BEZIER);

            graphUtil.invalidateGraph();
        }
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