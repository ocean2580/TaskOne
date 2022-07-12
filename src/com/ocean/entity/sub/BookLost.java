package com.ocean.entity.sub;

import com.ocean.entity.Lost;

public class BookLost extends Lost {
    private String bookName;

    public BookLost(String place, String date, String bookName) {
        super(place, date);
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "BookLost{" +
                "place='" + this.getPlace() + '\'' +
                ", date='" + this.getDate() + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
