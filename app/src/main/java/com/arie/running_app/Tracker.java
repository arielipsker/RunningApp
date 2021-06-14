package com.arie.running_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class Tracker extends Thread implements Runnable {
    private GoogleMap map;
    private LatLng m1;
    private Activity activity;
    private LatLng b;
    private boolean x;
    private double d=0;
    private FusedLocationProviderClient fusedLocationProviderClient;

    public Tracker(FusedLocationProviderClient fusedLocationProviderClient) {
        activity = new Activity();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
        x = true;
    }

    /**
     * Sets activity.
     *
     * @param activity the activity
     */
    public void setActivity(Activity activity)
    {
        this.activity=activity;
    }

    public void setX(boolean x) {
        this.x = x;
    }


    public boolean isX() {
        return x;
    }


    public Activity getActivity() {
        return activity;
    }


    public void setM1(LatLng m1)
    {
        this.m1=m1;

    }


    public void setMap(GoogleMap map) {
        this.map=map;
    }


    public GoogleMap getMap()
    {
        return map;
    }


    public LatLng getM1() {
        return m1;
    }


    public double getd1()
    {
        return d;
    }




    @Override

    public void run() {

        while (x==true)
        {
            activity.runOnUiThread(new Runnable() {
                @SuppressLint("MissingPermission")
                @Override
                public void run() {
                    fusedLocationProviderClient.getLastLocation().addOnSuccessListener(activity, new OnSuccessListener<Location>(){
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                LatLng c=new LatLng(location.getLatitude(), location.getLongitude());
                                        map.addPolyline(new PolylineOptions().geodesic(true).add(m1).add(c).width(5));
                                d = d+ Distance.distance(c.latitude,m1.latitude,c.longitude,m1.longitude);
                                m1=c;
                            }
                        }
                    });


                }

            });
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }



}
