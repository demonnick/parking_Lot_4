package com.parking.lot;


import java.sql.Time;
/**
 * A Representation of a Parking lot.
 */

public class Ticket {


    private int ID;
    private Time time_in;
    private Time time_out;
    private Boolean is_lost;
    private int cost;


    public Ticket(int ID, Time time_in, Time time_out, Boolean is_lost, int Cost) {

        this.ID = ID;
        this.time_in = time_in;
        this.time_out = time_out;
        this.is_lost = is_lost;
        this.cost = Cost;


    }


    public Ticket() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Time getTime_in() {
        return time_in;
    }

    public void setTime_in(Time time_in) {
        this.time_in = time_in;
    }

    public Time getTime_out() {
        return time_out;
    }

    public void setTime_out(Time time_out) {
        this.time_out = time_out;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int Cost) {
        this.cost = Cost;
    }


    public Boolean getIs_lost() {
        return is_lost;
    }

    public void setIs_lost(Boolean is_lost) {
        this.is_lost = is_lost;
    }


}