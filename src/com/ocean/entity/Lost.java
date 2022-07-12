package com.ocean.entity;


public class Lost {
    private String place;
    private String date;

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public Lost(String place, String date) {
        this.place = place;
        this.date = date;
    }

    public Lost() {
    }

    @Override
    public String toString() {
        return "Lost{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
