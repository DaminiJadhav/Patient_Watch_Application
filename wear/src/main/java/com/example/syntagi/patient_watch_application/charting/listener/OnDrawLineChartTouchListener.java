package com.example.syntagi.patient_watch_application.charting.listener;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.io.Serializable;

public class OnDrawLineChartTouchListener extends SimpleOnGestureListener implements OnTouchListener,Serializable {

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}

}
