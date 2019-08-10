package android.example.gcuweatherapp.DaysPage;

import android.example.gcuweatherapp.R;

public class WeatherIconSelection {

    public static int getWeatherDescriptorIcon(String rainProbability){
        int temp_icon =0;
        switch(rainProbability){
            case "Light Rain":
                temp_icon = R.drawable.light_rain;
                break;
            case "Light Cloud":
                temp_icon = R.drawable.light_cloud;
                break;
            case "Sunny":
                temp_icon = R.drawable.sun_star;
                break;
            case "Thundery Showers":
                temp_icon = R.drawable.heavy_rain;
                break;
            case "Clear Sky":
                temp_icon = R.drawable.clear_cloud;
                break;
            case "Sunny Intervals":
                temp_icon = R.drawable.sun_star;
                break;
            case "Light Rain Showers":
                temp_icon = R.drawable.light_rain;
                break;
        }
        return temp_icon;
    }
}
