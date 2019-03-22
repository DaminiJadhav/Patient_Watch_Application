package com.example.syntagi.patient_watch_application;

import android.content.Context;
import android.graphics.Color;


import com.example.syntagi.patient_watch_application.charting.charts.CombinedChart;
import com.example.syntagi.patient_watch_application.charting.components.AxisBase;
import com.example.syntagi.patient_watch_application.charting.components.Legend;
import com.example.syntagi.patient_watch_application.charting.components.XAxis;
import com.example.syntagi.patient_watch_application.charting.components.YAxis;
import com.example.syntagi.patient_watch_application.charting.data.BarData;
import com.example.syntagi.patient_watch_application.charting.data.BarDataSet;
import com.example.syntagi.patient_watch_application.charting.data.BarEntry;
import com.example.syntagi.patient_watch_application.charting.data.BubbleData;
import com.example.syntagi.patient_watch_application.charting.data.BubbleDataSet;
import com.example.syntagi.patient_watch_application.charting.data.BubbleEntry;
import com.example.syntagi.patient_watch_application.charting.data.CandleData;
import com.example.syntagi.patient_watch_application.charting.data.CandleDataSet;
import com.example.syntagi.patient_watch_application.charting.data.CandleEntry;
import com.example.syntagi.patient_watch_application.charting.data.ChartData;
import com.example.syntagi.patient_watch_application.charting.data.CombinedData;
import com.example.syntagi.patient_watch_application.charting.data.Entry;
import com.example.syntagi.patient_watch_application.charting.data.LineData;
import com.example.syntagi.patient_watch_application.charting.data.LineDataSet;
import com.example.syntagi.patient_watch_application.charting.data.ScatterData;
import com.example.syntagi.patient_watch_application.charting.data.ScatterDataSet;
import com.example.syntagi.patient_watch_application.charting.formatter.IAxisValueFormatter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentActivity;

public class GraphUtil implements Serializable {
    private XAxis xAxis;
    private ArrayList<ChartData> chartData = new ArrayList<>();

    private CombinedChart combinedChart;
    private Context context;
    private float SCATTER_SIZE = 8;
    private float candleSize = 0.35f;
    private float minScalYAxis = 1f;
    private float maxScalYAxis = 100f;
    private GraphListener graphListener;

    public GraphUtil(CombinedChart combinedChart, Context context, GraphListener graphListener) {
        this.combinedChart = combinedChart;
        this.context = context;
        this.graphListener = graphListener;
        initChart();
    }


    private void initChart() {
        combinedChart.getDescription().setEnabled(false);
        combinedChart.setBackgroundColor(Color.WHITE);
        combinedChart.setDrawGridBackground(false);
        combinedChart.setDrawBarShadow(false);
        combinedChart.setDrawValueAboveBar(false);
        combinedChart.setHighlightFullBarEnabled(false);
        combinedChart.setMaxVisibleValueCount(10);
        combinedChart.setVisibleXRangeMaximum(10);


        this.combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });

        Legend legend = combinedChart.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        setYAxis();

        xAxis = combinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(1f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value > 0) {
                    return graphListener.getTitle(value);
                }
                return "";
            }
        });
    }

    private void setYAxis() {
        YAxis rightAxis = combinedChart.getAxisRight();
        maxScalYAxis=maxScalYAxis+10;
        rightAxis.setDrawZeroLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawTopYLabelEntry(false);
        rightAxis.setAxisMinimum(minScalYAxis); // this replaces setStartAtZero(true)
        if (maxScalYAxis > 0) {
            rightAxis.setAxisMaxValue(maxScalYAxis);
        }

        YAxis leftAxis = combinedChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(minScalYAxis); // this replaces setStartAtZero(true)
        if (maxScalYAxis > 0) {
            leftAxis.setAxisMaxValue(maxScalYAxis);
        }
    }

    private void checkMax(float value) {
        if (value > maxScalYAxis) {
            maxScalYAxis = value;
        }
    }

    protected void  generateScattersData(ArrayList<Entry> scatterList, String scatterTitle, int scatterColor) {
        ScatterData scatterData = new ScatterData();
        ScatterDataSet set = new ScatterDataSet(scatterList, scatterTitle);
        set.setColor(scatterColor);
        set.setScatterShapeSize(SCATTER_SIZE);
        set.setDrawValues(true);
        scatterData.addDataSet(set);
        chartData.add(scatterData);
    }

    public void generateCandle(List<CandleEntry> candleEntryArrayList, String candleTitle, int candleColor) {
        CandleData d = new CandleData();
        CandleDataSet set = new CandleDataSet(candleEntryArrayList, candleTitle);
        set.setDecreasingColor(candleColor);
        set.setShadowColor(candleColor);
        set.setBarSpace(candleSize);
        set.setShadowWidth(24);
        set.setValueTextSize(10);
        set.setDrawValues(true);
        d.addDataSet(set);
        chartData.add(d);
    }

    protected void generateBubbleData(ArrayList<BubbleEntry> bubbleEntries, String bubbleTitle, int bubbleColor) {
        BubbleData bubbleData = new BubbleData();
        BubbleDataSet set = new BubbleDataSet(bubbleEntries, bubbleTitle);
        set.setColor(bubbleColor);
        set.setValueTextSize(0);
        set.setValueTextColor(Color.WHITE);
        set.setHighlightCircleWidth(1.5f);
        set.setNormalizeSizeEnabled(true);
        set.setDrawValues(true);
        bubbleData.addDataSet(set);
        chartData.add(bubbleData);
    }

    private void generateLineData(ArrayList<Entry> lineEntriesList, String lineTitle, int lineColor) {
        LineData d = new LineData();
        LineDataSet set = new LineDataSet(lineEntriesList, lineTitle);
        set.setColor(lineColor);
        set.setLineWidth(2f);
        set.setCircleColor(lineColor);
        set.setCircleColorHole(lineColor);
        set.setCircleRadius(1f);
        set.setCircleHoleRadius(0.5f);
        set.setFillColor(lineColor);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(lineColor);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);
        chartData.add(d);
    }


    private void generateBarData(ArrayList<BarEntry> barEntries, String barTitle, int barColor) {
        BarDataSet set = new BarDataSet(barEntries, barTitle);
        set.setColor(barColor);
        set.setValueTextColor(Color.rgb(60, 220, 78));
        set.setValueTextSize(10f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData d = new BarData(set);
//        BarData d = new BarData(set1, set2);
        d.setBarWidth(barWidth);

        // make this BarData object grouped
        d.groupBars(0, groupSpace, barSpace); // start at x = 0
        chartData.add(d);
    }

    public void invalidateGraph() {
        CombinedData data = new CombinedData();
        setYAxis();
        data.setData(chartData);
        data.calcMinMax();
        xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        combinedChart.setData(data);
        combinedChart.invalidate();
    }

    public void addLineGraph(ArrayList<Entry> entries, String lineTitle, int lineColor, LineDataSet.Mode mode) {
        LineData d = new LineData();
        LineDataSet set = new LineDataSet(entries, lineTitle);
        set.setColor(lineColor);
        set.setLineWidth(2f);
        set.setCircleColor(lineColor);
        set.setCircleColorHole(lineColor);
        set.setCircleRadius(1f);
        set.setCircleHoleRadius(0.5f);
        set.setFillColor(lineColor);
        set.setMode(mode);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(lineColor);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);
        for(Entry entry:entries){
            checkMax(entry.getY());
        }
        chartData.add(d);
    }

    public interface GraphListener {
        String getTitle(float position);
    }
}