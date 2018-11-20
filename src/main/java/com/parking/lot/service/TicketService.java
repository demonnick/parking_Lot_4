package com.parking.lot.service;



import com.parking.lot.Ticket;
import com.parking.lot.dao.ParkingLotDao;
import java.sql.Time;
import java.time.LocalTime;
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
     * @param time_in is the time that the car enters the parking lot and receives a ticket.
     * @param time_out is the exit time of the car.
     * @param is_lost is an indication if the ticket has been lost.
     * @return a newly created ticket.
     */
    public void createTicket(int ID, LocalTime time_in, LocalTime time_out, Boolean is_lost) {
        ParkingLotDao.
    }

    public List<Ticket> getAllTickets() {
        return parkingLotDao.getTickets();
    }
}