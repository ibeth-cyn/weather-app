package android.example.gcuweatherapp.HomePage;

import android.example.gcuweatherapp.HomePage.CityNameAdapter;
import android.example.gcuweatherapp.R;
import android.example.gcuweatherapp.RSSFeed.DataStore;
import android.example.gcuweatherapp.RSSFeed.RSSFeed;
import android.example.gcuweatherapp.RSSFeed.Weather;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Name: Elizabeth Michael Akpan
 * Matric Number: S1719014
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CityNameAdapter cityNameAdapter;
    private String city_names[];

    //RSSFeed newRssFeed = new RSSFeed();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //System.out.println(newRssFeed.execute());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        city_names = getResources().getStringArray(R.array.list_city_name);

        recyclerView = (RecyclerView) findViewById(R.id.list_city_name);

        cityNameAdapter = new CityNameAdapter(this, city_names);

        recyclerView.setAdapter(cityNameAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RSSFeed rss = new RSSFeed(this);
        rss.execute();
        try {
            HashMap<String, ArrayList<Weather>> weatherData = rss.get();
            weatherData.keySet();
            DataStore.setWeatherData(weatherData);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
