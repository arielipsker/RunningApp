package com.arie.running_app;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //, LocationListener

    private GoogleMap mMap;
    Chronometer chronometer;
    private boolean running = true;
    private long pauseoffset;
    //   private GoogleMap mMap;
    Button start;
    boolean a = true;
    Tracker act;
    //private FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //act = new Tracker(fusedLocationProviderClient);
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
        //act.start();
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng start = new LatLng(32.071378, 34.876048);
        LatLng middle = new LatLng(32.071692, 34.867566);
        LatLng finish = new LatLng(32.070292, 34.862255);
        LatLng streerWorkout = new LatLng(32.071301, 34.865710);
        LatLng streerWorkout1 = new LatLng(32.079128, 34.876997);
        mMap.addMarker(new MarkerOptions().position(start).title("Start"));
        mMap.addMarker(new MarkerOptions().position(finish).title("Finish").snippet("you run 2 km"));
        mMap.addMarker(new MarkerOptions().position(middle).title("Middle").snippet("you run 1 km"));
        mMap.addMarker(new MarkerOptions().position(streerWorkout).title("StreerWorkout"));
        mMap.addMarker(new MarkerOptions().position(streerWorkout1).title("StreerWorkout"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 13f));
        mMap.addPolyline(new PolylineOptions().add(start, middle).width(5).color(Color.RED));
        mMap.addPolyline(new PolylineOptions().add(middle, finish).width(5).color(Color.RED));

        //start(mMap);
    }


    public void start(GoogleMap mMap) {
        if (running) {
   //         pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();

//            chronometer.stop();
//            running = false;
//            act.setX(false);
//
//
//            String x = String.valueOf((int) ((pauseoffset / 1000) % 60));
//            String y = String.valueOf((int) ((pauseoffset / 60000) % 60));
//            String z = String.valueOf((int) (pauseoffset / 3600000));
//            String l = z + ":" + y + ":" + x;
//            double d = (int) (act.getd1() * 1000);
//            double di = d / 1000;
//            Stats activity = new Stats();
//            double spee = (int) ((((int) (pauseoffset / 60000)) / di) * 100);
//            double speed = spee / 100;
//            activity.setAvgspeed(speed);
//            activity.setTime(l);
//            activity.setDistance(di);
//        } else if (!running) {
//            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
//            chronometer.start();
//            running = true;
           // Location m1 = mMap.getMyLocation();
           // LatLng a = new LatLng(m1.getLatitude(), m1.getLongitude());


//            act.setM1(a);
//            act.setMap(mMap);
//            act.setX(true);
//            act.setActivity(this);
//            act.start();
        }

    }


//    @Override
  //  public void onLocationChanged(@NonNull Location location) {
    //    Log.d("pause",location.toString()+"");

    //}
}