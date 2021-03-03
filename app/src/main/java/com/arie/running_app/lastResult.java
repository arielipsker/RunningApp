package com.arie.running_app;

public class lastResult {
    private int time;
    private int distance;

    public lastResult(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
