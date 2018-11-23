package com.parking.lot.service;


import com.parking.lot.Ticket;
import com.parking.lot.TicketWCost;
import com.parking.lot.dao.ParkingLotDao;

import java.sql.Time;

import java.time.*;
import java.util.Date;
import java.util.List;

/**
 * A Service that represents all the interactions for a Pool Match.
 */
public class TicketService {

    private ParkingLotDao parkingLotDao;
    Ticket ti = new Ticket();
    private int fee;


    public TicketService(ParkingLotDao parkingLotDao) {

        this.parkingLotDao = parkingLotDao;
    }


    public void createTicket(Ticket t) {


        ti.setID(t.getID());
        ti.setTime_in(t.getTime_in());
        ti.setTime_out(t.getTime_out());
        ti.setIs_lost(t.getIs_lost());
        parkingLotDao.createTicket(ti);


    }



    public List<Ticket> getAllTickets() {


        return parkingLotDao.getTickets();
    }


        public void calcCost() {


            long calc = Duration.between(ti.getTime_out().toLocalTime(),ti.getTime_in().toLocalTime()).toMinutes();

            if(calc<0){
                calc = calc*-1;
            }
            calc = calc/60;

        //System.out.println(calc);

            








    }


    public TicketWCost ticket (){

        TicketWCost ticket = new TicketWCost(ti.getID(),ti.getTime_in(),ti.getTime_out(),ti.getIs_lost(),fee);
    }


}