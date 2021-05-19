package com.arie.running_app;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Chronometer chronometer;
    private boolean running;
    private long pauseoffset;
    //   private GoogleMap mMap;
    Button start ;
    boolean a=true;
    tracker act = new tracker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        mMap.setMinZoomPreference(7.0f);
//        mMap.setMaxZoomPreference(14.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f));
        mMap.addPolyline(new PolylineOptions().add(new LatLng(32.077203563042346, 34.8722418877401), new LatLng(32.09083758267705, 34.86167193191998)).width(5).color(Color.RED));
      //  start(mMap);
    }

    public void start(GoogleMap mMap) {
        if (running) {
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
        } else if (!running) {
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

    }
}