package com.arie.running_app;

public class Week {

    String week;
    String monday;
    String wednesday;
    String friday;

    public Week(String week, String monday, String wednesday, String friday) {
        this.week = week;
        this.monday = monday;
        this.wednesday = wednesday;
        this.friday = friday;
    }

    public String getWeek() {
        return week;
    }

    public String getMonday() {
        return monday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getFriday() {
        return friday;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }
}
