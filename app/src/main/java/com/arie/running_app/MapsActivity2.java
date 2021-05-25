package com.arie.running_app;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;

import android.widget.Chronometer;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    Chronometer chronometer;
    private boolean running;
    private long pauseoffset;
 //   private GoogleMap mMap;
    Button start ;
    boolean a=true;
    Polyline line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        chronometer = findViewById(R.id.chronometer);
        Intent intent = new Intent(this, MapsActivity2.class);
        stopService(intent);
        //   SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        //      .findFragmentById(R.id.map);
        //   mapFragment.getMapAsync(Main5Activity.this);
        if (isGoogleApiAvailabe()) {
          //  initMap();
        }
    }


        @Override
        public void onMapReady (GoogleMap mMap){
            GoogleMap googleMap=mMap;
//            mMap = googleMap;
            LatLng sydney = new LatLng(32.077203563042346, 34.8722418877401);
//            LatLng rabin = new LatLng(32.09083758267705, 34.86167193191998);
//            // Add a marker in Sydney and move the camera
//
             mMap.addMarker(new MarkerOptions().position(sydney).title("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB"));
//            //CameraUpdate zoom = CameraUpdateFactory.zoomTo(3);
            mMap.setMinZoomPreference(700.0f);
            mMap.setMaxZoomPreference(50.0f);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f));
//
//            mMap.addMarker(new MarkerOptions().position(sydney));
//            mMap.addPolyline(new PolylineOptions().add(new LatLng(32.077203563042346, 34.8722418877401), new LatLng(32.09083758267705, 34.86167193191998)).width(5).color(Color.RED));
            start(mMap);
            //add poligon
        /*
        LatLng l1 = new LatLng(32.14352346732022, 34.881858072393655);
        LatLng l2 = new LatLng(32.083872237381854, 34.79809754541207);
        LatLng l3 = new LatLng(32.077212653941594, 34.872231158904036);
        mMap.addPolyline(new PolylineOptions().geodesic(true).add(l1).add(l2).add(l3));

         */
        }




    private void initMap() {
//        if(mapFragment == null)
//        {
//            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.map);
//            mapFragment.getMapAsync(MapsActivity2.this);
//        }
    }

    private boolean isGoogleApiAvailabe() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int Available = api.isGooglePlayServicesAvailable(this);
        if (Available == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(Available)) {
            Toast.makeText(MapsActivity2.this, "הפעל שירותי מיקום", Toast.LENGTH_LONG).show();
        }

        return false;
    }
     Tracker act = new Tracker();


    public void start(GoogleMap mMap) {
        if(running) {
            pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometer.stop();
            running = false;
            act.setX(false);


            String x = String.valueOf((int) ((pauseoffset / 1000) % 60));
            String y = String.valueOf((int) ((pauseoffset / 60000) % 60));
            String z = String.valueOf((int) (pauseoffset / 3600000));
            String l = z + ":" + y + ":" + x;
            double d = (int) (act.getd1() * 1000);
            double di = d / 1000;
            Stats activity = new Stats();
            double spee = (int) ((((int) (pauseoffset / 60000)) / di) * 100);
            double speed = spee / 100;
            activity.setAvgspeed(speed);
            activity.setTime(l);
            activity.setDistance(di);
        }
        else if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;
            Location m1 = mMap.getMyLocation();
            LatLng a = new LatLng(m1.getLatitude(), m1.getLongitude());

            act.setM1(a);
            act.setMap(mMap);
            act.setX(true);
            act.setActivity(this);
            act.start();
        }

 }}
