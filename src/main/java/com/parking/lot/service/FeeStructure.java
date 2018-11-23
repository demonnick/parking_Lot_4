package com.parking.lot.service;

public class FeeStructure {

    private String time;
    private int price;
    private int start;
    private int end;

    public FeeStructure(String time, int price, int start, int end) {
        this.time = time;
        this.price = price;
        this.start = start;
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time_in) {
        this.time = time_in;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}