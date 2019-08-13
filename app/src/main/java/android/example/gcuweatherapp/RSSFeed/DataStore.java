package android.example.gcuweatherapp.RSSFeed;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Name: Elizabeth Michael Akpan
 * Matric Number: S1719014
 */
public class DataStore {
    public static HashMap<String, ArrayList<Weather>> getWeatherData() {
        return weatherData;
    }

    public static void setWeatherData(HashMap<String, ArrayList<Weather>> weatherData) {
        DataStore.weatherData = weatherData;
    }

    public static HashMap<String, ArrayList<Weather>> weatherData;

}
