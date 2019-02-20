package com.example.syntagi.patient_watch_application.Interfaces;


import com.example.syntagi.patient_watch_application.models.LoginResponse;
import com.example.syntagi.patient_watch_application.models.OtpResponse;
import com.example.syntagi.patient_watch_application.models.medicine.CurrentMedicineResponse;
import com.example.syntagi.patient_watch_application.Post;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineDetailData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
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
    Call<CurrentMedicineResponse> medicine(@Query("patientId") String patientId, @Header("authToken") String token,@Header("roleType") int roleType);

    @GET("/syntagi/medicines/getById")
    Call<MedicineDetailData> getMedicineById(@Query("id")String id,@Header("authToken")String token,@Header("roleType") int roleType);

}
