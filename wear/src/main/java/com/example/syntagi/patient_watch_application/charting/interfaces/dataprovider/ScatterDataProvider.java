package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;

import com.example.syntagi.patient_watch_application.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
