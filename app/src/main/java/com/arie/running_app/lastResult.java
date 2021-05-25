package com.arie.running_app;

public class lastResult {
    private String time;
    private Date date;

    public lastResult(String time, Date date) {
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
