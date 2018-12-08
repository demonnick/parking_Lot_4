package com.parking.lot;

public class FeeStructure {

    private int lotId;
    private String time_info;
    private int price;
    private int start;
    private int end;
    private int feeId;



    public FeeStructure(int LotID, String time_info, int price, int start, int end, int FID) {
        this.lotId = LotID;
        this.time_info = time_info;
        this.price = price;
        this.start = start;
        this.end = end;
        this.feeId = FID;
    }

    public FeeStructure() {

    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public String getTime_info() {
        return time_info;
    }

    public void setTime_info(String time_in) {
        this.time_info = time_in;
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

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }
}