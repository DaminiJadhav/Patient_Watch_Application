package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;

import com.example.syntagi.patient_watch_application.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
