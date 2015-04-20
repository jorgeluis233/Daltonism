package green.edu.intec.daltonism;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MapActivity extends ActionBarActivity {

    private MapFragment mapView;
    private GoogleMap map;
    private LatLng currLatLng;
    private LocationManager locationManager;
    private String provider;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        questions = (ArrayList<Question>)intent.getSerializableExtra("QUESTION_LIST");
        showResults();

        //Setting up the map
        // Gets the MapView from the XML layout and creates it
        mapView = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MapActivity.this.updateMarker(latLng);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showResults(){

        TextView textResult = (TextView)findViewById(R.id.viewTextResult);
        TextView textAverage = (TextView)findViewById(R.id.textViewAverage);
        String level = "";
        double count = 0;

        for (Question q : questions){
            if(q.isCorrect()){
                count++;
            }
        }

        double percentage = (count/38)*100;
        DecimalFormat df = new DecimalFormat("0.00");
        int t = (int)count;
        textAverage.setText("You got "+ t+ " out of 38 answers correct for a "+df.format(percentage)+"% accuracy");
        if(count >=32){
            level = "Zero";
        } else if(count >= 27){
            level = "Fair";
        }
        else if(count >= 22){
            level = "Moderate";
        } else {
            level = "Severe";
        }

        textResult.setText(level);

    }

    private void updateMarker(LatLng latLong){

        currLatLng = latLong;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(currLatLng, 16);

        map.clear();
        map.addMarker(new MarkerOptions().position(currLatLng).title("Nearest"));
        map.animateCamera(cameraUpdate);
    }

}
