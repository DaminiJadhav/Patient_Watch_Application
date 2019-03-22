package com.example.syntagi.patient_watch_application.charting.exception;

import java.io.Serializable;

public class DrawingDataSetNotCreatedException extends RuntimeException implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DrawingDataSetNotCreatedException() {
		super("Have to create a new drawing set first. Call ChartData's createNewDrawingDataSet() method");
	}

}
