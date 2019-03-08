package com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider;

import com.example.syntagi.patient_watch_application.charting.components.YAxis;
import com.example.syntagi.patient_watch_application.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
