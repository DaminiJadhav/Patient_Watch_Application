package com.example.syntagi.patient_watch_application.charting.renderer;

import android.graphics.Canvas;


import com.example.syntagi.patient_watch_application.charting.animation.ChartAnimator;
import com.example.syntagi.patient_watch_application.charting.charts.Chart;
import com.example.syntagi.patient_watch_application.charting.charts.CombinedChart;
import com.example.syntagi.patient_watch_application.charting.data.BarData;
import com.example.syntagi.patient_watch_application.charting.data.BubbleData;
import com.example.syntagi.patient_watch_application.charting.data.CandleData;
import com.example.syntagi.patient_watch_application.charting.data.ChartData;
import com.example.syntagi.patient_watch_application.charting.data.CombinedData;
import com.example.syntagi.patient_watch_application.charting.data.LineData;
import com.example.syntagi.patient_watch_application.charting.data.ScatterData;
import com.example.syntagi.patient_watch_application.charting.highlight.Highlight;
import com.example.syntagi.patient_watch_application.charting.utils.ViewPortHandler;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Renderer class that is responsible for rendering multiple different data-types.
 */
public class CombinedChartRenderer extends DataRenderer implements Serializable {

    /**
     * all rederers for the different kinds of data this combined-renderer can draw
     */
    protected List<DataRenderer> mRenderers = new ArrayList<DataRenderer>(5);

    protected WeakReference<Chart> mChart;

    public CombinedChartRenderer(CombinedChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        mChart = new WeakReference<Chart>(chart);
        createRenderers();
    }

    /**
     * Creates the renderers needed for this combined-renderer in the required order. Also takes the DrawOrder into
     * consideration.
     */
    public void createRenderers() {

        mRenderers.clear();

        CombinedChart chart = (CombinedChart) mChart.get();
        if (chart == null)
            return;

        CombinedData data = chart.getData();
        if(data==null){
            return;
        }
        for (ChartData chartData : data.getData()) {
            if (chartData instanceof BarData) {
                        mRenderers.add(new BarChartRenderer(chart, mAnimator, mViewPortHandler,(BarData)chartData));
            }
            if (chartData instanceof BubbleData) {
                        mRenderers.add(new BubbleChartRenderer(chart, mAnimator, mViewPortHandler,(BubbleData)chartData));
            }
            if (chartData instanceof LineData) {
                        mRenderers.add(new LineChartRenderer(chart, mAnimator, mViewPortHandler,(LineData) chartData));
            }
            if (chartData instanceof CandleData) {
                        mRenderers.add(new CandleStickChartRenderer(chart, mAnimator, mViewPortHandler,(CandleData)chartData));
            }
            if (chartData instanceof ScatterData) {
                        mRenderers.add(new ScatterChartRenderer(chart, mAnimator, mViewPortHandler,(ScatterData)chartData));
            }

//            switch (order) {
//                case BAR:
//                    if (chart.getBarData() != null)
//                        mRenderers.add(new BarChartRenderer(chart, mAnimator, mViewPortHandler));
//                    break;
//                case BUBBLE:
//                    if (chart.getBubbleData() != null)
//                        mRenderers.add(new BubbleChartRenderer(chart, mAnimator, mViewPortHandler));
//                    break;
//                case LINE:
//                    if (chart.getLineData() != null)
//                        mRenderers.add(new LineChartRenderer(chart, mAnimator, mViewPortHandler));
//                    break;
//                case CANDLE:
//                    if (chart.getCandleData() != null) {
//                        mRenderers.add(new CandleStickChartRenderer(chart, mAnimator, mViewPortHandler));
//                    }
//                    break;
//                case SCATTER:
//                    if (chart.getScatterData() != null)
//                        mRenderers.add(new ScatterChartRenderer(chart, mAnimator, mViewPortHandler));
//                    break;
//            }
        }
    }

    @Override
    public void initBuffers() {

        for (DataRenderer renderer : mRenderers)
            renderer.initBuffers();
    }

    @Override
    public void drawData(Canvas c) {

        for (DataRenderer renderer : mRenderers)
            renderer.drawData(c);
    }

    @Override
    public void drawValues(Canvas c) {
        for (DataRenderer renderer : mRenderers)
            renderer.drawValues(c);
    }

    @Override
    public void drawExtras(Canvas c) {

        for (DataRenderer renderer : mRenderers)
            renderer.drawExtras(c);
    }

    protected List<Highlight> mHighlightBuffer = new ArrayList<Highlight>();

    @Override
    public void drawHighlighted(Canvas c, Highlight[] indices) {

        Chart chart = mChart.get();
        if (chart == null) return;

        for (DataRenderer renderer : mRenderers) {
            ChartData data = null;

            if (renderer instanceof BarChartRenderer)
                data = ((BarChartRenderer) renderer).getBarData();
            else if (renderer instanceof LineChartRenderer)
                data = ((LineChartRenderer) renderer).getLineData();
            else if (renderer instanceof CandleStickChartRenderer)
                data = ((CandleStickChartRenderer) renderer).getCandleData();
            else if (renderer instanceof ScatterChartRenderer)
                data = ((ScatterChartRenderer) renderer).getScatterData();
            else if (renderer instanceof BubbleChartRenderer)
                data = ((BubbleChartRenderer) renderer).getBubbleData();

            int dataIndex = data == null ? -1 : ((CombinedData) chart.getData()).getData().indexOf(data);

            mHighlightBuffer.clear();

            for (Highlight h : indices) {
                if (h.getDataIndex() == dataIndex || h.getDataIndex() == -1)
                    mHighlightBuffer.add(h);
            }

            renderer.drawHighlighted(c, mHighlightBuffer.toArray(new Highlight[mHighlightBuffer.size()]));
        }
    }

    /**
     * Returns the sub-renderer object at the specified index.
     *
     * @param index
     * @return
     */
    public DataRenderer getSubRenderer(int index) {
        if (index >= mRenderers.size() || index < 0)
            return null;
        else
            return mRenderers.get(index);
    }

    /**
     * Returns all sub-renderers.
     *
     * @return
     */
    public List<DataRenderer> getSubRenderers() {
        return mRenderers;
    }

    public void setSubRenderers(List<DataRenderer> renderers) {
        this.mRenderers = renderers;
    }
}
