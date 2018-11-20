package com.parking.lot;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;


import java.sql.Time;
import java.time.LocalTime;

/**
 * A Representation of a Parking lot.
 */
@JsonIgnoreProperties({"winner"})
public class Ticket {

    private int ID;
    private LocalTime time_in;
    private LocalTime time_out;
    private Boolean is_lost;
    private Ticket ticket;


    public Ticket(int ID, LocalTime time_in, LocalTime time_out, Boolean is_lost) {

        this.ID = ID;
        this.time_in = time_in;
        this.time_out = time_out;

        this.is_lost = is_lost;


    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalTime getTime_in() {
        return time_in;
    }

    public void setTime_in(LocalTime time_in) {
        this.time_in = time_in;
    }

    public LocalTime getTime_out() {
        return time_out;
    }

    public void setTime_out(LocalTime time_out) {
        this.time_out = time_out;
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