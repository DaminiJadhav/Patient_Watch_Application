package com.example.syntagi.patient_watch_application.Model1;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("firstName")
    private String FirstName;
    @SerializedName("lastName")
    private String LastName;
    @SerializedName("phoneNumber")
    private String PhoneNumber;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }



    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }




    public User(String phoneNumber)
    {
         this.PhoneNumber=phoneNumber;
    }


}
