package com.parking.lot.service;


import com.parking.lot.Ticket;
import com.parking.lot.dao.ParkingLotDao;

import java.sql.Time;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Service that represents all the interactions for a Pool Match.
 */
public class TicketService {

    private ParkingLotDao parkingLotDao;
    Ticket ti = new Ticket();
    private long duration;


    public TicketService(ParkingLotDao parkingLotDao) {

        this.parkingLotDao = parkingLotDao;
    }


    public void createTicket(Ticket t) {


        ti.setID(t.getID());
        ti.setTime_in(t.getTime_in());
        ti.setTime_out(new Time(00,00,00));
        ti.setIs_lost(false);
        ti.setCost(0);
        parkingLotDao.createTicket(ti);


    }


    public List<Ticket> getAllTickets() {


        return parkingLotDao.getTickets();
    }

    public Ticket getTicket(int id){
        return parkingLotDao.getTicket(id);
    }


    public int calcCost() {

        int cost = 0;

        long duration = Duration.between(ti.getTime_in().toLocalTime(), ti.getTime_out().toLocalTime()).toMinutes();
        if (duration < 0) {
            ti.setIs_lost(true);
        }


       System.out.println(duration);

        List<FeeStructure> fs = new ArrayList<>();

        fs.add(new FeeStructure("to 30 min", 10, 0, 30));
        fs.add(new FeeStructure("to 1 hour", 20, 31, 60));
        fs.add(new FeeStructure("to 1 hour 30 min", 30, 61, 90));
        fs.add(new FeeStructure("to 2 hours", 40, 91, 120));
        fs.add(new FeeStructure("to 2 hours 30 min", 50, 120, 150));

        for (int i = 0; i <4; i++) {
            System.out.println(fs.get(i).getStart());

            if (duration >= fs.get(i).getStart() && duration <= fs.get(i).getEnd()) {


                cost = fs.get(i).getPrice();


            } else if (duration > fs.get(4).getEnd() || duration < fs.get(0).getStart()) {
                cost = fs.get(4).getEnd() + 100;
                ti.setIs_lost(true);

         }


        }

        return cost;


    }

    public void updateTicket(Ticket ticket) {


        ti.setID(ticket.getID());
        ti.setTime_in(parkingLotDao.getTicket(ticket.getID()).getTime_in());
        ti.setTime_out(ticket.getTime_out());
        ti.setIs_lost(ticket.getIs_lost());
        ti.setCost(calcCost());
        parkingLotDao.updateTicket(ti);


    }


}