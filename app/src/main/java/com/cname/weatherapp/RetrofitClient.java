package com.cname.weatherapp;

import android.util.Base64;

import com.google.android.gms.common.api.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static weatherapi myApi;

    /*private static RetrofitClient instance = null;
    private weatherapi myApi;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(weatherapi.BASE_URL)
               *//* .addConverterFactory(new ToStringConverterFactory())*//*
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(weatherapi.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public weatherapi getMyApi() {
        return myApi;
    }
*/


    private static Retrofit retrofit = null;


    public static  Retrofit getClient(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(weatherapi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(weatherapi.class);
        }


        return retrofit;


        }
    public weatherapi getMyApi() {
        return myApi;
    }


}
