package com.example.syntagi.patient_watch_application.models.appointment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmergencyContact extends BaseApiData {


@SerializedName("firstName")
@Expose
private Object firstName;
@SerializedName("lastName")
@Expose
private Object lastName;
@SerializedName("name")
@Expose
private Object name;
@SerializedName("number")
@Expose
private Object number;
@SerializedName("relationship")
@Expose
private Object relationship;


public Object getFirstName() {
return firstName;
}

public void setFirstName(Object firstName) {
this.firstName = firstName;
}

public Object getLastName() {
return lastName;
}

public void setLastName(Object lastName) {
this.lastName = lastName;
}

public Object getName() {
return name;
}

public void setName(Object name) {
this.name = name;
}

public Object getNumber() {
return number;
}

public void setNumber(Object number) {
this.number = number;
}

public Object getRelationship() {
return relationship;
}

public void setRelationship(Object relationship) {
this.relationship = relationship;
}

}