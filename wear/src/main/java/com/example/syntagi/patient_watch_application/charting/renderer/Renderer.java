
package com.example.syntagi.patient_watch_application.charting.renderer;

import com.example.syntagi.patient_watch_application.charting.utils.ViewPortHandler;

import java.io.Serializable;

/**
 * Abstract baseclass of all Renderers.
 * 
 * @author Philipp Jahoda
 */
public abstract class Renderer implements Serializable {

    /**
     * the component that handles the drawing area of the chart and it's offsets
     */
    protected ViewPortHandler mViewPortHandler;

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }
}
