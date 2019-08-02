package android.example.gcuweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CityNameAdapter cityNameAdapter;
    private String city_names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_names = getResources().getStringArray(R.array.list_city_name);

        recyclerView = (RecyclerView) findViewById(R.id.list_city_name);

        cityNameAdapter = new CityNameAdapter(this, city_names);

        recyclerView.setAdapter(cityNameAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
