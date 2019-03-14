package com.example.syntagi.patient_watch_application.models.vitals;

import com.example.syntagi.patient_watch_application.Vital;
import com.example.syntagi.patient_watch_application.models.BaseApiResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghu on 22/8/16.
 */
public class VitalsModelResponse extends BaseApiResponse {
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
    public void save() {
//        Preferences.saveData(AppConstants.PREF_KEYS.VITALS_RESPONCE,new Gson().toJson(this));
    }
    public static VitalsModelResponse getSaved(){
//        String json = Preferences.getData(AppConstants.PREF_KEYS.VITALS_RESPONCE, "");
//        if(!TextUtils.isEmpty(json)){
//            return new Gson().fromJson(json,VitalsModelResponse.class);
//        }
        return  null;
    }
    public static Vital getByName(String name){
        VitalsModelResponse saved = getSaved();
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