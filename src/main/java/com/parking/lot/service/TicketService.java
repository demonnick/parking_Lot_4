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


    public void createTicket(Ticket t) {

        Ticket ti = new Ticket();
        ti.setID(t.getID());
        ti.setTime_in(t.getTime_in());
        ti.setTime_out(t.getTime_out());
        ti.setIs_lost(t.getIs_lost());
        parkingLotDao.createTicket(ti);


    }

    public List<Ticket> getAllTickets() {
        return parkingLotDao.getTickets();
    }
}