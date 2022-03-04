package com.cname.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView date,cname,temp,dec,pressuer,humidity,sunrise,sunset;
    EditText search;
    FloatingActionButton searchbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        cname = findViewById(R.id.cityName);
        temp = findViewById(R.id.main_temp_value);
        dec = findViewById(R.id.description);
        pressuer = findViewById(R.id.pressre_value);
        humidity = findViewById(R.id.humidityValue);
        sunrise = findViewById(R.id.max_temp_value);
        sunset = findViewById(R.id.min_temp_value);
        search = findViewById(R.id.search_city_edittext);
        searchbutton = findViewById(R.id.floatingActionButton);


        String currentDate = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date());
        date.setText(currentDate);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc =search.getText().toString().trim();
                SharedPreferences preferences = getSharedPreferences("weather", MODE_PRIVATE);
                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("weather", abc);
                edit.apply();
                String  Weather = preferences.getString("weather", null);
                getWeatherData(Weather);
                cname.setText(Weather);
            }
        });

    }

    private void getWeatherData(String name) {

        weatherapi apiInterface = RetrofitClient.getClient().create(weatherapi.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                try {

                    String displayValue= epochToIso8601(response.body().getSys().getsunrise());
                    sunrise.setText(displayValue+" AM");
                    String displayValue1=epochToIso8601(response.body().getSys().getsunset());
                    sunset.setText(displayValue1+" PM");
                    temp.setText(String.format(response.body().getMain().getTemp())+"°C");
                    pressuer.setText(String.valueOf(response.body().getMain().getpressure()));
                    humidity.setText(response.body().getMain().getHumidity()+"%");
                  //  dec.setText(response.body().getWeather().getClass().getdescription());
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    String epochToIso8601(long time) {
        String format = "hh:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(time * 1000));
    }
}

