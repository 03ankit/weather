package com.cname.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weatherapi {

    String BASE_URL = "https://api.openweathermap.org";
    @GET("data/2.5/weather?appid=fe4bbac574900566c1e0241e69692b56&units=metric")

    Call<Example> getWeatherData(@Query("q") String name);
}
