package com.ocean.entity.sub;

import com.ocean.entity.Lost;

public class CardLost extends Lost {
    private String ownerName;
    private String college;
    private String id;

    public CardLost(String place, String date, String ownerName, String college, String id) {
        super(place, date);
        this.ownerName = ownerName;
        this.college = college;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CardLost{" +
                " place='" + this.getPlace() + '\'' +
                ", date='" + this.getDate() + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", college='" + college + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCollege() {
        return college;
    }

    public String getId() {
        return id;
    }
}
