package com.parking.lot.rest;


import com.parking.lot.Ticket;
import com.parking.lot.service.TicketService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This is a REST Service for getting and updating tickets.
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
     * Get all tickets from the service.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAll() {


        return (List<Ticket>) (ticketService.getAllTickets());


    }

    /**
     * Create a ticket
     *
     * @param t is the ticket information entered.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)

    public void createTicket(Ticket t) {


        ticketService.createTicket(t);
    }

    /**
     * Create a ticket
     *
     * @param ticket is the ticket information entered.
     * @param id     is the ID of the ticket to be updated.
     */
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateTicket(@PathParam("id") int id, Ticket ticket) {

        Ticket t = new Ticket();
        t.setID(id);
        t.setIs_lost(ticket.getIs_lost());
        t.setTime_out(ticket.getTime_out());
        ticketService.updateTicket(t);


    }


}