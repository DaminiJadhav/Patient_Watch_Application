package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;

import com.example.syntagi.patient_watch_application.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
