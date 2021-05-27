package com.arie.running_app;

import java.util.Calendar;
import java.util.TimeZone;


public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDat() {
        return day;
    }

    public int getMonth(){ return month; }

    public int getYear(){ return year; }

    public void setDay(int day) { this.day = day; }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        String currentDate;
        currentDate = this.day + "/" + this.month + "/" + this.year;
        return currentDate;
    }

    public String getCurrentDate(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.day = calendar.get(Calendar.DATE);
        this.month = calendar.get(Calendar.MONTH)+1;
        this.year = calendar.get(Calendar.YEAR);

        return this.toString();
    }





}
