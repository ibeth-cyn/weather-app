package android.example.gcuweatherapp.DaysPage;

import android.content.Intent;
import android.example.gcuweatherapp.R;
import android.example.gcuweatherapp.RSSFeed.DataStore;
import android.example.gcuweatherapp.RSSFeed.RSSFeed;
import android.example.gcuweatherapp.RSSFeed.Weather;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Name: Elizabeth Michael Akpan
 * Matric Number: S1719014
 */
public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent intent = getIntent();
        String city = intent.getStringExtra("cityName");

        TextView cityName = (TextView) findViewById(R.id.city_name);
        cityName.setText(city);

        TextView textView = (TextView) findViewById(R.id.week_day);

        ArrayList<Weather> location = DataStore.getWeatherData().get(city);
        textView.setText(location.get(0).getDescription());

    }
}
