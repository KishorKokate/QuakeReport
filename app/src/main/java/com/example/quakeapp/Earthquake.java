package com.example.quakeapp;

public class Earthquake {
    // @param magnitude earth quake magnitude
    private String magnitude;

    // @param city location of earthquake
    private String place;
    private String url;
    // @param date , the  date of the earthquake
    private String time;

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Earthquake(String magnitude, String place, String time,String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.url=url;
    }
}
