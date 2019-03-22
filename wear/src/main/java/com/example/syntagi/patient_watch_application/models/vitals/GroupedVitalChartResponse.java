package com.example.syntagi.patient_watch_application.models.vitals;

import com.example.syntagi.patient_watch_application.models.BaseApiResponse;

import java.io.Serializable;
import java.util.List;

public class GroupedVitalChartResponse extends BaseApiResponse implements Serializable {
    private List<GroupedVitalChartData> data;
    public List<GroupedVitalChartData> getData() {
        return data;
    }
}