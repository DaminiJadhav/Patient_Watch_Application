package com.example.syntagi.patient_watch_application.models.vitals;

import java.io.Serializable;
import java.util.List;

public class GroupedVitalChartData implements Serializable {
    private String xValue;
    private float bpDiastolic;
    private float bpSystolic;
    private List<VitalChartData> otherList;

    public String getxValue() {
        if (xValue != null) {
            String[] split = xValue.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : split) {
                stringBuilder.append(s).append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        return xValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public float getBpDiastolic() {
        return bpDiastolic;
    }

    public void setBpDiastolic(float bpDiastolic) {
        this.bpDiastolic = bpDiastolic;
    }

    public float getBpSystolic() {
        return bpSystolic;
    }

    public void setBpSystolic(float bpSystolic) {
        this.bpSystolic = bpSystolic;
    }

    public List<VitalChartData> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<VitalChartData> otherList) {
        this.otherList = otherList;
    }

}