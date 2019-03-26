package com.example.syntagi.patient_watch_application.models.appointments;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {

    @SerializedName("addressLine1")
    private String addressLine1;
    @SerializedName("addressLine2")
    private String addressLine2;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("pincode")
    private String pincode;
    @SerializedName("country")
    private String country;
    @SerializedName("description")
    private String description;
    public String getAddressLine1() {
        if (addressLine1 == null) {
            return "";
        }
        return addressLine1;
    }

    public static Address parseJson(String response) {
        Gson gson = new Gson();
        Address address = new Address();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray results = jsonObject.getJSONArray("results");
            if (results.length() > 0) {
                JSONObject resultsJSONObject = results.getJSONObject(0);
                if (resultsJSONObject.has("location")) {
                    JSONObject location = resultsJSONObject.getJSONObject("location");
                    address.setLatitude(location.getDouble("lat") + "");
                    address.setLongitude(location.getDouble("lng") + "");
                }
                if (resultsJSONObject.has("geometry")) {
                    JSONObject geometry = resultsJSONObject.getJSONObject("geometry");
                    if (geometry.has("location")) {
                        JSONObject location = geometry.getJSONObject("location");
                        address.setLatitude(location.getDouble("lat") + "");
                        address.setLongitude(location.getDouble("lng") + "");
                    }
                }
                if (resultsJSONObject.has("address_components")) {
                    JSONArray addressComponents = resultsJSONObject.getJSONArray("address_components");
                    for (int x = 0; x < addressComponents.length(); x++) {
                        JSONObject addComponentJson = addressComponents.getJSONObject(x);
//                        AddressComponent addressComponent = gson.fromJson(addComponentJson.toString(), AddressComponent.class);
//                        List<String> types = addressComponent.getTypes();
//                        if (types != null) {
//                            if (types.contains("street_number")) {
//                                address.setAddressLine1(addressComponent.getLong_name());
//                            }
//                            if (types.contains("route")) {
//                                String addressLine1 = address.getAddressLine1();
//                                if(!TextUtils.isEmpty(addressLine1)){
//                                    address.setAddressLine1(addressLine1 + ", " + addressComponent.getLong_name());
//                                }else {
//                                    address.setAddressLine1(addressComponent.getLong_name());
//                                }
//                            }
//                            if (types.contains("sublocality_level_3")) {
//                                String addressLine1 = address.getAddressLine1();
//                                if(!TextUtils.isEmpty(addressLine1)){
//                                    address.setAddressLine1(addressLine1 + ", " + addressComponent.getLong_name());
//                                }else {
//                                    address.setAddressLine1(addressComponent.getLong_name());
//                                }
//                            }
//                            if (types.contains("sublocality_level_2")) {
//                                address.setAddressLine2(addressComponent.getLong_name());
//                            }
//                            if (types.contains("sublocality_level_1")) {
//                                String addressLine2 = address.getAddressLine2();
//                                if(!TextUtils.isEmpty(addressLine2)){
//                                    address.setAddressLine2(addressLine2 + ", " + addressComponent.getLong_name());
//                                }else {
//                                    address.setAddressLine2(addressComponent.getLong_name());
//                                }
//                            }
//                            if (types.contains("administrative_area_level_2")) {
//                                address.setCity(addressComponent.getLong_name());
//                            }
//
//                            if (types.contains("administrative_area_level_1")) {
//                                address.setState(addressComponent.getLong_name());
//                            }
//                            if (types.contains("country")) {
//                                address.setCountry(addressComponent.getLong_name());
//                            }
//                            if (types.contains("postal_code")) {
//                                address.setPincode(addressComponent.getLong_name());
//                            }
//                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!TextUtils.isDigitsOnly(address.addressLine1)) {
                        stringBuilder.append(address.addressLine1);
                    }
                    if (!TextUtils.isDigitsOnly(address.addressLine2)) {
                        stringBuilder.append(address.addressLine2);
                    }
                    address.setDescription(address.addressLine1 + " " + address.addressLine2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        if(!TextUtils.isEmpty(addressLine1)){
            stringBuilder.append(addressLine1).append(", ");
        }
        if(!TextUtils.isEmpty(addressLine2)){
            stringBuilder.append(addressLine2).append(", ");
        }
        if(stringBuilder.length()>1){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        description=stringBuilder.toString();
        return addressLine2;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}