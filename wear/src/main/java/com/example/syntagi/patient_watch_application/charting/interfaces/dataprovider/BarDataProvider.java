package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;


import com.example.syntagi.patient_watch_application.charting.data.BarData;

public interface BarDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BarData getBarData();
    boolean isDrawBarShadowEnabled();
    boolean isDrawValueAboveBarEnabled();
    boolean isHighlightFullBarEnabled();
}
