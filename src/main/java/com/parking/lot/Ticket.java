package com.parking.lot;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;


import java.sql.Time;
import java.time.LocalDate;

import java.time.LocalTime;
import java.sql.Date;


/**
 * A Representation of a Parking lot.
 */
@JsonIgnoreProperties({"winner"})
public class Ticket {

    private int ID;
    private Time time_in;
    private Time time_out;
    private Date date;
    private Boolean is_lost;
    private Ticket ticket;


    public Ticket(int ID, Time time_in, Time time_out, Date date, Boolean is_lost) {

        this.ID = ID;
        this.time_in = time_in;
        this.time_out = time_out;
        this.date = date;
        this.is_lost = is_lost;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIs_lost() {
        return is_lost;
    }

    public void setIs_lost(Boolean is_lost) {
        this.is_lost = is_lost;
    }


    public void calculateCost() {

    }

    public Ticket getTicket() {
        return ticket;
    }
}