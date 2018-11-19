package com.parking.lot.service;



import com.parking.lot.Ticket;
import com.parking.lot.dao.ParkingLotDao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * A Service that represents all the interactions for a Pool Match.
 */
public class TicketService {

    private ParkingLotDao parkingLotDao;

    public TicketService(ParkingLotDao parkingLotDao) {
        this.parkingLotDao = parkingLotDao;
    }

    /**
     * Create a Ticket.
     * @param ID is the ID of the ticket.
     * @param time_in is the timethat the car enters the parking lot and receives a ticket.
     * @param time_out is the exit time of the car.
     * @param is_lost is an indication if the ticket has been lost.
     * @return a newly created ticket.
     */
    public Ticket createTicket(int ID, Time time_in, Time time_out, Boolean is_lost) {
        return new Ticket(ID,time_in,time_out,is_lost);
    }

    public List<Ticket> getAllTickets() {
        return parkingLotDao.getPoolMatches();
    }
}