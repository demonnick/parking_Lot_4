package com.parking.lot.service;


import com.parking.lot.FeeStructure;
import com.parking.lot.Ticket;
import com.parking.lot.dao.TicketDao;

import java.sql.Time;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Service that represents all the interactions for a ticket.
 */
public class TicketService implements TicketServiceInterface {

    private TicketDao ticketDao;

    Ticket ti = new Ticket();
    private long duration;


    public TicketService(TicketDao ticketDao) {

        this.ticketDao = ticketDao;
    }

    /**
     * Create a ticket.
     *
     * @param t is the ticket information entered.
     */
    @Override
    public Ticket createTicket(Ticket t) {


        ti.setID(t.getID());
        ti.setTime_in(t.getTime_in());
        ti.setTime_out(new Time(00, 00, 00));
        ti.setIs_lost(false);
        ti.setCost(0);
        ti.setLot(1);
        ticketDao.createTicket(ti);


        return  ti;
    }

    /**
     * Get all tickets.
     */
    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getTickets();
    }

    /**
     * Get a single ticket.
     */
    @Override
    public Ticket getTicket(int id) {
        return ticketDao.getTicket(id);
    }

    /**
     * Calculate ticket cost.
     */
    @Override
    public int calcCost() {

        int cost = 0;

        long duration = Duration.between(ti.getTime_in().toLocalTime(), ti.getTime_out().toLocalTime()).toMinutes();
        if (duration < 0) {
            ti.setIs_lost(true);
        }




        List<FeeStructure> fs = new ArrayList<>();

        fs.add(new FeeStructure(1,"to 30 min", 10, 0, 30,1));
        fs.add(new FeeStructure(1,"to 1 hour", 20, 31, 60,2));
        fs.add(new FeeStructure(1,"to 1 hour 30 min", 30, 61, 90,3));
        fs.add(new FeeStructure(1,"to 2 hours", 40, 91, 120,4));
        fs.add(new FeeStructure(1,"to 2 hours 30 min", 50, 120, 150,5));

        for (int i = 0; i < 4; i++) {

            if (duration >= fs.get(i).getStart() && duration <= fs.get(i).getEnd()) {

                cost = fs.get(i).getPrice();

            } else if (duration > fs.get(4).getEnd() || duration < fs.get(0).getStart()) {

                cost = fs.get(4).getEnd() + 100;
                ti.setIs_lost(true);
            }
        }

        return cost;

    }

    /**
     * Update a ticket.
     *
     * @param ticket is the ticket information entered.
     */
    @Override
    public void updateTicket(Ticket ticket) {


        ti.setID(ticket.getID());
        ti.setTime_in(ticketDao.getTicket(ticket.getID()).getTime_in());
        ti.setTime_out(ticket.getTime_out());
        ti.setIs_lost(ticket.getIs_lost());
        ti.setCost(calcCost());

        ticketDao.updateTicket(ti);

    }


}