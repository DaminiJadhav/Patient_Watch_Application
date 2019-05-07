package com.example.syntagi.patient_watch_application.enum_package;

import android.text.TextUtils;
import com.example.syntagi.patient_watch_application.utils.CustomDateUtils;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rahul on 3/30/2017.
 */

public enum Reminder {
    MOR(0, "08:00 AM"),
    NOON(1, "01:00 PM"),
    EVE(2, "05:00 PM"),
    NIGHT(3, "04:15 PM");

    public int remId;
//    public int timeVal;
    public String time;

    Reminder(int remId, String time) {
        this.remId = remId;
        this.time = time;
    }


    public static Calendar  getCalender(String time) {
        Calendar calendar = Calendar.getInstance();
        if (!TextUtils.isEmpty(time)) {
            try {
                String date= CustomDateUtils.formatDate(new Date(),CustomDateUtils.BASE_DATE_FORMAT);
                Date d = CustomDateUtils.convertStringToDate(date+" "+time,CustomDateUtils.BASE_DATE_FORMAT+" "+CustomDateUtils.REMINDER_TIME_FORMAT);
                calendar.setTime(d);
                if(calendar.getTimeInMillis()<=System.currentTimeMillis()){
                    calendar.add(Calendar.DAY_OF_MONTH,1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return calendar;
    }

    public int getRemId() {
        return remId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static Reminder findById(int reminderId) {
        for (Reminder reminder : values()) {
            if (reminder.getRemId() == reminderId) {
                return reminder;
            }
        }
        return MOR;
    }
}
