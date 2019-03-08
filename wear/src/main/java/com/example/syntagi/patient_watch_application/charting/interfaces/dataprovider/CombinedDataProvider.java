package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;

import com.example.syntagi.patient_watch_application.charting.data.CombinedData;
/**
 * Created by philipp on 11/06/16.
 */
public interface CombinedDataProvider extends LineDataProvider, BarDataProvider, BubbleDataProvider, CandleDataProvider, ScatterDataProvider {

    CombinedData getCombinedData();
}
