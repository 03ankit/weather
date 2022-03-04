package com.cname.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("description")
    String description;

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
}
