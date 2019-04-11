package com.example.syntagi.patient_watch_application.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDateUtils {

    public static final String PATIENT_QUEUE_DATE_FORMAT = "dd MMMM yyyy";
    public static final String BASE_DATE_FORMAT = "dd-MM-yyyy";
    public static final String MONTH_YEAR_FORMAT = "MM-yyyy";
    public static final String BASE_TIME_FORMAT = "HH:mm";
    public static final String JAVA_DATE_PATTERN = "E MMM dd HH:mm:ss Z yyyy";
    public static final String FOLLOW_UP_DATE_FORMAT = "MMMM dd,yyyy";
    public static final String REMINDER_TIME_FORMAT = "hh:mm aa";
    public static final String PRESCRIPTION_DATE_FORMAT = "MMMM dd,yyyy";
    public static final String APPOINTMENT_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String DOB_DATE_FORMAT = "dd/MM/yyyy";
    public static final String BILL_NUMBER_TIME_FORMAT = "HHmmss";
    public static final String NOTIFICATION_DATE_FORMAT = "dd MMM, yyyy HH:mm";
    public static final String REMINDER_ID_FORMAT = "HHmm";
    public static final String NOTIFICATION_FORMAT = "yyyy:MM:dd HH:mm:ss";
    public static final String[] FORMATS = { "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ",
            "dd-MM-yyyy'T'HH:mm:ss'Z'", "dd-MM-yyyy'T'HH:mm:ssZ", "dd-MM-yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", "MM/dd/yyyy HH:mm:ss",
            "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS",
            "MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss", "yyyy:MM:dd HH:mm:ss", "dd-MM-yyyy", "yyyy-MM-dd",
            "yyyy MM dd", "dd/MM/yyyy", "MMMM dd,yyyy hh:mm aa", "MMMM dd,yyyy","HHmm","dd MMM, yyyy HH:mm","dd MMMM yyyy"};

    public static final String INVALID_FORMAT = "InvalidFormat";

    public static String convertDateFormat(String currentDate,
                                            String currentDateFormatString, String reqDateFormat) {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat(currentDateFormatString);
        SimpleDateFormat formater = new SimpleDateFormat(reqDateFormat);
        try {
            Date d=new Date();
            if (d!=null){
                d = currentDateFormat.parse(currentDate);
                return formater.format(d);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currentDate;
    }

    public static Date convertStringToDate(String dateString, String dateFormat)
            throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.parse(dateString);
    }


    public static String convertCreated(long millisecond){
        Date date = new Date(millisecond);
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(millisecond);
        Calendar calendarCurrent= Calendar.getInstance();
        if(calendar.get(Calendar.YEAR)==calendarCurrent.get(Calendar.YEAR)){
            return formatDate(date,"dd MMM, HH:mm");
        }
        return formatDate(date,NOTIFICATION_DATE_FORMAT);
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


}
