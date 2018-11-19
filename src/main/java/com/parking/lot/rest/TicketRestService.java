package com.parking.lot.rest;


import com.parking.lot.Ticket;
import com.parking.lot.service.TicketService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This is a REST Service for getting pool matches.
 */
@Path("/ticket")
public class TicketRestService {

    private TicketService ticketService;

    /**
     * This class requires a {@link TicketService} to deal with tickets.
     * @param ticketService the {@link TicketService} to use.
     */
    public TicketRestService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Get a pool match from the service.
     * @return a newly created poolmatch.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTicket() {
        return ticketService.getAllTickets();
    }
}