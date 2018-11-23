package com.parking.lot.rest;


import com.parking.lot.Ticket;
import com.parking.lot.service.TicketService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * This is a REST Service for getting pool matches.
 */
@Path("/")
public class TicketRestService {

    private TicketService ticketService;

    /**
     * This class requires a {@link TicketService} to deal with tickets.
     *
     * @param ticketService the {@link TicketService} to use.
     */
    public TicketRestService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Get a ticket from the service.
     *
     * @return a newly created ticket.
     */


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAll()  {




        ticketService.calcCost();
        return (List<Ticket>) (ticketService.getAllTickets());


    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)

    public void createTicket(Ticket t){



         ticketService.createTicket(t);
    }



}