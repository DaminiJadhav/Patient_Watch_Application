
package com.example.syntagi.patient_watch_application.charting.data;

import com.example.syntagi.patient_watch_application.charting.interfaces.datasets.IBubbleDataSet;

import java.io.Serializable;
import java.util.List;

public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> implements Serializable {

    public BubbleData() {
        super();
    }

    public BubbleData(IBubbleDataSet... dataSets) {
        super(dataSets);
    }

    public BubbleData(List<IBubbleDataSet> dataSets) {
        super(dataSets);
    }


    /**
     * Sets the width of the circle that surrounds the bubble when highlighted
     * for all DataSet objects this data object contains, in dp.
     * 
     * @param width
     */
    public void setHighlightCircleWidth(float width) {
        for (IBubbleDataSet set : mDataSets) {
            set.setHighlightCircleWidth(width);
        }
    }
}
