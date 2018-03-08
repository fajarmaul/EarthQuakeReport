package maulanovich.earthquakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //create static arrayllist
        //ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("4.7", "San Francisco", "February 2017"));
//        earthquakes.add(new Earthquake("5.0", "Texas", "March 2018"));
//        earthquakes.add(new Earthquake("3.2", "Puerto Rico", "January 2017"));
//        earthquakes.add(new Earthquake("5.5", "Jakarta", "March 2017"));

    //With JSON arrayList
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        earthquakeListView.setAdapter(adapter);
    }
}
