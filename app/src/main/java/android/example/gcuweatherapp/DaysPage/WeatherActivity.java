package android.example.gcuweatherapp.DaysPage;

import android.content.Intent;
import android.example.gcuweatherapp.R;
import android.example.gcuweatherapp.RSSFeed.DataStore;
import android.example.gcuweatherapp.RSSFeed.RSSFeed;
import android.example.gcuweatherapp.RSSFeed.Weather;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Name: Elizabeth Michael Akpan
 * Matric Number: S1719014
 */
public class WeatherActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> weekDay;
    HashMap<String, List<String>> forecastDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        Intent intent = getIntent();
        String city = intent.getStringExtra("cityName");
        ArrayList<Weather> location = DataStore.getWeatherData().get(city);
        weekDay=new ArrayList<>();
        forecastDetail = new HashMap<>();
        for (Weather day:location){
            weekDay.add(day.getDay());
            String[] weatherData = new String[8];
            weatherData[0] =  day.getPublicationDate();
            weatherData[1] = "Minimum Temperature: " + day.getMinimumTemperature();
            weatherData[2] = "Wind Direction: " + day.getWindDirection();
            weatherData[3] = "Humidity: " + day.getHumidity();
            weatherData[4] = "Visibility: " + day.getVisibility();
            weatherData[5] = "UV Risk: " + day.getUvRisk();
            weatherData[6] = "Name: Elizabeth Michael Akpan";
            weatherData[7] = "Matric Number: S1719014";
            forecastDetail.put(day.getDay(), Arrays.asList(weatherData));

        }

        expandableListAdapter = new WeatherAdapter(this, weekDay, forecastDetail);
        expandableListView.setAdapter(expandableListAdapter);


    }
}
