package com.cname.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("sunrise")
    String sunrise;

    @SerializedName("sunset")
    String sunset;

    public long getsunrise() { return Long.parseLong(sunrise); }

    public void setsunrise(String sunrise) { this.sunrise = sunrise; }

    public long getsunset() { return Long.parseLong(sunset); }

    public void setsunset(String sunset) { this.sunset = sunset; }
}
