package com.cname.weatherapp;

import com.google.android.gms.awareness.state.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }


    @SerializedName("sys")
    private Sys sys;

    public Sys getSys() { return sys; }

    public void setSys(Sys sys) { this.sys = sys; }

    @SerializedName("Weather")
    private Weather weather;


    public Weather getWeather() { return weather; }
    public void setWeather(Weather weather) { this.weather = weather; }




//    @SerializedName("main")
//    private Main main;
//
//
//
//
//   /* @SerializedName("Weather")
//    private List<Weather> weatherList;*/
//
//
//
//    public Main getMain() {
//        return main;
//    }
//
//    public void setMain(Main main) {
//        this.main = main;
//    }
//
//
//
//   /* public List<Weather> getWeatherList() { return weatherList; }
//
//    public void setWeatherList(List<Weather> weatherList) { this.weatherList = weatherList; }*/



}
