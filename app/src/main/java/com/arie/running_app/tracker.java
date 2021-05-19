package com.arie.running_app;

import android.app.Activity;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class tracker extends Thread implements Runnable {
    private GoogleMap map;
    private LatLng m1;
    private Activity activity;
    private LatLng b;
    private boolean x;
    private double d=0;

    /**
     * Sets activity.
     *
     * @param activity the activity
     */
    public void setActivity(Activity activity)
    {
        this.activity=activity;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(boolean x) {
        this.x = x;
    }

    /**
     * Is x boolean.
     *
     * @return the boolean
     */
    public boolean isX() {
        return x;
    }

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Sets m 1.
     *
     * @param m1 the m 1
     */
    public void setM1(LatLng m1)
    {
        this.m1=m1;

    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(GoogleMap map) {
        this.map=map;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public GoogleMap getMap()
    {
        return map;
    }

    /**
     * Gets m 1.
     *
     * @return the m 1
     */
    public LatLng getM1() {
        return m1;
    }


    @Override
    public void run() {

        while (x==true)
        {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    LatLng c=new LatLng(map.getMyLocation().getLatitude(),map.getMyLocation().getLongitude());

                    map.addPolyline(new PolylineOptions().geodesic(true).add(m1).add(c).width(5));
                    d = d+ Distance.distance(c.latitude,m1.latitude,c.longitude,m1.longitude);
                    m1=c;
                }

            });
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * Gets 1.
     *
     * @return the 1
     */
    public double getd1()
    {
        return d;
    }
}
