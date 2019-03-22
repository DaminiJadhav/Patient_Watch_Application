package com.example.syntagi.patient_watch_application.charting.highlight;


import com.example.syntagi.patient_watch_application.charting.charts.PieChart;
import com.example.syntagi.patient_watch_application.charting.data.Entry;
import com.example.syntagi.patient_watch_application.charting.interfaces.datasets.IPieDataSet;

import java.io.Serializable;

/**
 * Created by philipp on 12/06/16.
 */
public class PieHighlighter extends PieRadarHighlighter<PieChart> implements Serializable {

    public PieHighlighter(PieChart chart) {
        super(chart);
    }

    @Override
    protected Highlight getClosestHighlight(int index, float x, float y) {

        IPieDataSet set = mChart.getData().getDataSet();

        final Entry entry = set.getEntryForIndex(index);

        return new Highlight(index, entry.getY(), x, y, 0, set.getAxisDependency());
    }
}
