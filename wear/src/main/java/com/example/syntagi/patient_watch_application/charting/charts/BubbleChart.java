
package com.example.syntagi.patient_watch_application.charting.charts;

import android.content.Context;
import android.util.AttributeSet;

import com.example.syntagi.patient_watch_application.charting.data.BubbleData;
import com.example.syntagi.patient_watch_application.charting.interfaces.dataprovider.BubbleDataProvider;
import com.example.syntagi.patient_watch_application.charting.renderer.BubbleChartRenderer;


/**
 * The BubbleChart. Draws bubbles. Bubble chart implementation: Copyright 2015
 * Pierre-Marc Airoldi Licensed under Apache License 2.0. In the BubbleChart, it
 * is the area of the bubble, not the radius or diameter of the bubble that
 * conveys the data.
 *
 * @author Philipp Jahoda
 */
public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {

    public BubbleChart(Context context) {
        super(context);
    }

    public BubbleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BubbleChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();

        mRenderer = new BubbleChartRenderer(this, mAnimator, mViewPortHandler,getBubbleData());
    }

    public BubbleData getBubbleData() {
        return mData;
    }
}