package com.example.syntagi.patient_watch_application.models.vitals;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.example.syntagi.patient_watch_application.AppConstants;
import com.example.syntagi.patient_watch_application.Vital;
import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.cache.DiskLruCache;

/**
 * Created by raghu on 22/8/16.
 */
public class VitalsModelResponse extends BaseApiResponse implements Serializable{
    private List<Vital> data;
    public List<Vital> getData() {
        if(data==null){
            data=new ArrayList<>();
        }
        return data;
    }
    public void setData(List<Vital> data) {
        this.data = data;
    }

    public static VitalsModelResponse parseJson(String json){
//        Preferences.saveData(AppConstants.PREF_KEYS.VITALS_RESPONCE,json);


        return new Gson().fromJson(json,VitalsModelResponse.class);
    }
    public void save(Context context) {
        Gson gson=new Gson();
        String vitaljson=gson.toJson(this);
        SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(AppConstants.PREF_KEYS.VITALS_RESPONCE,vitaljson);
        editor.apply();
    }

    public static VitalsModelResponse getSaved(Context context){
//        SharedPreferences sharedPreferences=context.getSharedPreferences("Preference",Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences!=null){
            String json=sharedPreferences.getString(AppConstants.PREF_KEYS.VITALS_RESPONCE,"");
            if (!TextUtils.isEmpty(json)){
                Gson gson=new Gson();
                return  gson.fromJson(json,VitalsModelResponse.class);
            }
        }

//        String json = Preferences.getData(AppConstants.PREF_KEYS.VITALS_RESPONCE, "");
//        if(!TextUtils.isEmpty(json)){
//            return new Gson().fromJson(json,VitalsModelResponse.class);
//        }
        return  null;
    }
    public static Vital getByName(String name,Context context){
        VitalsModelResponse saved = getSaved(context);
        if (saved!=null){
            List<Vital> data = saved.getData();
            for(Vital vital:data){
                if(vital.getVitalName().equalsIgnoreCase(name)){
                    return vital;
                }
                if(vital.getShortCode().equalsIgnoreCase(name)){
                    return vital;
                }
            }
        }
        return  null;
    }
}