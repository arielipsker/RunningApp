package com.arie.running_app;

public class Stats {
    private String time;
    private double distance;
    private double avgspeed;

    /**
     * Instantiates a new Stats.
     */
    public Stats() {
    }

    /**
     * Instantiates a new Stats.
     *
     * @param time     the time
     * @param distance the distance
     * @param avgspeed the avgspeed
     */
    public Stats(String time, double distance, double avgspeed) {
        this.time = time;
        this.distance = distance;
        this.avgspeed = avgspeed;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets avgspeed.
     *
     * @return the avgspeed
     */
    public double getAvgspeed() {
        return avgspeed;
    }

    /**
     * Sets avgspeed.
     *
     * @param avgspeed the avgspeed
     */
    public void setAvgspeed(double avgspeed) {
        this.avgspeed = avgspeed;
    }
}