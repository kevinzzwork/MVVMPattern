package com.android.kz.mvvmpattern.model;

/**
 * User: Kevin
 * Date: 22/09/15
 * Time: 11:07 PM
 */
public class DateTimeViewItem {
    public String time;
    public String milliSec;
    public String date;

    public DateTimeViewItem(String time, String milliSec, String date) {
        this.time = time;
        this.milliSec = milliSec;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMilliSec() {
        return milliSec;
    }

    public void setMilliSec(String milliSec) {
        this.milliSec = milliSec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
