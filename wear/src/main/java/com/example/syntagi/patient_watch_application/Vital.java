package com.example.syntagi.patient_watch_application;

import android.text.TextUtils;

import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import com.plumillonforge.android.chipview.Chip;

import java.io.Serializable;

public class Vital extends BaseApiResponse implements Chip,Serializable {

    private String vitalId;
    private String vitalName;
    private String unit;
    private String shortCode;
    private double minValue;
    private double maxValue;
    private String value;
    private boolean showGraph;
    private boolean showWithVitals;
    private int graphType;
    private String colorCode;
    private String tempData;

    public boolean isSelected() {
        return !TextUtils.isEmpty(value);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public String getHint() {
        return unit;
    }

    public String getVitalId() {
        return vitalId;
    }

    public void setVitalId(String vitalId) {
        this.vitalId = vitalId;
    }


    public String getVitalName() {
        return vitalName;
    }

    public void setVitalName(String vitalName) {
        this.vitalName = vitalName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if ("N/A".equals(value)) {
            return;
        }
        this.value = value;
    }

    public String getFullString() {
        if (null == value) {
            value = "N/A";
        }
        return getVitalName() + " : " + value;
    }

    @Override
    public String getText() {
        return getFullString();
    }

    public boolean isShowGraph() {
        return showGraph;
    }

    public void setShowGraph(boolean showGraph) {
        this.showGraph = showGraph;
    }

    public int getGraphType() {
        return graphType;
    }

    public void setGraphType(int graphType) {
        this.graphType = graphType;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public boolean isShowWithVitals() {
        return showWithVitals;
    }

    public void setShowWithVitals(boolean showWithVitals) {
        this.showWithVitals = showWithVitals;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getTempData() {
        return tempData;
    }

    public void setTempData(String tempData) {
        this.tempData = tempData;
    }
}