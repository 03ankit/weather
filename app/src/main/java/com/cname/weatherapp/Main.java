package com.cname.weatherapp;

import com.google.android.gms.awareness.state.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Main {

        @SerializedName("temp")
        String temp;

        @SerializedName("pressure")
        String pressure;

        @SerializedName("humidity")
        String humidity;


        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }


        public String getpressure() {
                return pressure;
            }

        public void setpressure(String pressure) {
            this.pressure = pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }


}
