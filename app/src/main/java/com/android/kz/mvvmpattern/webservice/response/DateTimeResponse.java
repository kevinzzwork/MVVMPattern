package com.android.kz.mvvmpattern.webservice.response;

/**
 * User: Kevin
 * Date: 22/09/15
 * Time: 4:28 PM
 */
public class DateTimeResponse {
    public String time;
    public String milliseconds_since_epoch;
    public String date;

    public String getTime() {
        return time;
    }

    public String getMilliseconds_since_epoch() {
        return milliseconds_since_epoch;
    }

    public String getDate() {
        return date;
    }
}
