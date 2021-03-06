package com.example.syntagi.patient_watch_application.Interfaces;


import com.example.syntagi.patient_watch_application.Model1.LoginResponse;
import com.example.syntagi.patient_watch_application.Model1.OtpResponse;
import com.example.syntagi.patient_watch_application.Model2.CurrentMedicines;
import com.example.syntagi.patient_watch_application.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST("/patient/loginAndGenerateOtp")
//    Call<LoginResponse> getpost(@Field("number") String number);
//
//    @Multipart
//    @FormUrlEncoded
    @POST("/syntagi/patient/loginAndGenerateOtp")
    Call<LoginResponse> getpost(@Body Post post);


    @GET("/syntagi/sms/validateOtp")
    Call<OtpResponse> varify_otp(@Query("type") String type, @Query("value") String value, @Query("otp") String otp);

    @GET("/syntagi/prescription/getPatientCurrentMedications")
    Call<CurrentMedicines> medicine();



}
