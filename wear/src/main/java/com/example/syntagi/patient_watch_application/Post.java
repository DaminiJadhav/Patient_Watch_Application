package com.example.syntagi.patient_watch_application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class Post {
    @SerializedName("number")
    @Expose
    private String phone_number;

    public String getPhone_number(){
        return phone_number;
    }

    public String setPhone_number(String phone_number) {
       this.phone_number=phone_number;
        return null;
    }

//    @NonNull
//    @Override
//    public String toString() {
//      // return "Post{" + "phone_number='" +phone_number + '\''  ;
//        return "Post{" + "Phone Number=" + phone_number +"}";
//       // return super.toString();
//    }
}
