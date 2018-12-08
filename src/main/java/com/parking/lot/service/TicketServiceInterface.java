package com.parking.lot.service;

import com.parking.lot.Ticket;

import java.util.List;

public interface TicketServiceInterface {
    Ticket createTicket(Ticket t);

    List<Ticket> getAllTickets();

    Ticket getTicket(int id);

    int calcCost();

    void updateTicket(Ticket ticket);
}
