package com.example.syntagi.patient_watch_application.charting.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;

public class NumberUtils {
    public static Integer convertToInteger(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        try {
            return Integer.parseInt(value);

        } catch (Exception e) {

        }
        return 0;

    }
    public static Float convertToFloat(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0f;
        }
        try {
            return Float.parseFloat(value);

        } catch (Exception e) {

        }
        return 0f;

    }
    public static String convertFloatToPrintString(float value) {
        String number = converFloatToString(value);
            if (!TextUtils.isEmpty(number)){
                return number;
            }
        return "0";

    }

    private static String converFloatToString(float value) {
        if (value!=0){
            return convertToDecimal(value);
        }
        return "";
    }

    public static String convertToDecimal(double value) {
        if(value==0){
            return "0";
        }
        String format = new DecimalFormat("##.##").format(value);
        if("NaN".equalsIgnoreCase(format)){
            return ""+value;
        }
        String[] split = format.split(".");
        if(split.length>1){
            Integer integer = convertToInteger(split[1]);
            if(integer==0){
                return split[0];
            }
        }
        return format;
    }

}
