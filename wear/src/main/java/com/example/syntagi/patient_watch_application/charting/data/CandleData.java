package com.example.syntagi.patient_watch_application.charting.data;

import com.example.syntagi.patient_watch_application.charting.interfaces.datasets.ICandleDataSet;

import java.io.Serializable;
import java.util.List;

public class CandleData extends BarLineScatterCandleBubbleData<ICandleDataSet> implements Serializable {

    public CandleData() {
        super();
    }

    public CandleData(List<ICandleDataSet> dataSets) {
        super(dataSets);
    }

    public CandleData(ICandleDataSet... dataSets) {
        super(dataSets);
    }
}
