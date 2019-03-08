
package com.example.syntagi.patient_watch_application.charting.data;

import android.util.Log;


import com.example.syntagi.patient_watch_application.charting.highlight.Highlight;
import com.example.syntagi.patient_watch_application.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Data object that allows the combination of Line-, Bar-, Scatter-, Bubble- and
 * CandleData. Used in the CombinedChart class.
 *
 * @author Philipp Jahoda
 */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {

    private ArrayList<ChartData> data;

    public CombinedData() {
        super();
    }

    @Override
    public void calcMinMax() {

        if(mDataSets == null){
            mDataSets = new ArrayList<>();
        }
        mDataSets.clear();

        mYMax = -Float.MAX_VALUE;
        mYMin = Float.MAX_VALUE;
        mXMax = -Float.MAX_VALUE;
        mXMin = Float.MAX_VALUE;

        mLeftAxisMax = -Float.MAX_VALUE;
        mLeftAxisMin = Float.MAX_VALUE;
        mRightAxisMax = -Float.MAX_VALUE;
        mRightAxisMin = Float.MAX_VALUE;

        for (ChartData chartData : data) {
            chartData.calcMinMax();
            List<IBarLineScatterCandleBubbleDataSet<? extends Entry>> sets = chartData.getDataSets();
            mDataSets.addAll(sets);

            if (chartData.getYMax() > mYMax)
                mYMax = chartData.getYMax();

            if (chartData.getYMin() < mYMin)
                mYMin = chartData.getYMin();

            if (chartData.getXMax() > mXMax)
                mXMax = chartData.getXMax();

            if (chartData.getXMin() < mXMin)
                mXMin = chartData.getXMin();

            if (chartData.mLeftAxisMax > mLeftAxisMax)
                mLeftAxisMax = chartData.mLeftAxisMax;

            if (chartData.mLeftAxisMin < mLeftAxisMin)
                mLeftAxisMin = chartData.mLeftAxisMin;

            if (chartData.mRightAxisMax > mRightAxisMax)
                mRightAxisMax = chartData.mRightAxisMax;

            if (chartData.mRightAxisMin < mRightAxisMin)
                mRightAxisMin = chartData.mRightAxisMin;

        }
    }

    @Override
    public void notifyDataChanged() {
        for(ChartData chartData: data){
            chartData.notifyDataChanged();
        }
        calcMinMax(); // recalculate everything
    }

    /**
     * Get the Entry for a corresponding highlight object
     *
     * @param highlight
     * @return the entry that is highlighted
     */
    @Override
    public Entry getEntryForHighlight(Highlight highlight) {

        List<ChartData> dataObjects = data;

        if (highlight.getDataIndex() >= dataObjects.size())
            return null;

        ChartData data = dataObjects.get(highlight.getDataIndex());

        if (highlight.getDataSetIndex() >= data.getDataSetCount())
            return null;
        else {
            // The value of the highlighted entry could be NaN -
            //   if we are not interested in highlighting a specific value.

            List<Entry> entries = data.getDataSetByIndex(highlight.getDataSetIndex())
                    .getEntriesForXValue(highlight.getX());
            for (Entry entry : entries)
                if (entry.getY() == highlight.getY() ||
                        Float.isNaN(highlight.getY()))
                    return entry;

            return null;
        }
    }

    @Override
    public boolean removeDataSet(IBarLineScatterCandleBubbleDataSet<? extends Entry> d) {

        List<ChartData> datas = data;

        boolean success = false;

        for (ChartData data : datas) {

            success = data.removeDataSet(d);

            if (success) {
                break;
            }
        }

        return success;
    }

    @Deprecated
    @Override
    public boolean removeDataSet(int index) {
        Log.e("MPAndroidChart", "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    @Deprecated
    @Override
    public boolean removeEntry(Entry e, int dataSetIndex) {
        Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
        return false;
    }

    @Deprecated
    @Override
    public boolean removeEntry(float xValue, int dataSetIndex) {
        Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void setData(ArrayList<ChartData> data) {
        this.data = data;
    }

    public ArrayList<ChartData> getData() {
        return data;
    }
}
