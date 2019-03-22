package com.example.syntagi.patient_watch_application.models.appointment;

import com.example.syntagi.patient_watch_application.models.Address;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollegeData extends BaseApiData {


@SerializedName("name")
@Expose
private String name;
@SerializedName("address")
@Expose
private Address address;
@SerializedName("fromYear")
@Expose
private Integer fromYear;
@SerializedName("toYear")
@Expose
private Integer toYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getFromYear() {
        return fromYear;
    }

    public void setFromYear(Integer fromYear) {
        this.fromYear = fromYear;
    }

    public Integer getToYear() {
        return toYear;
    }

    public void setToYear(Integer toYear) {
        this.toYear = toYear;
    }
}