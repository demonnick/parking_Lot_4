package service;

import com.parking.lot.Ticket;
import com.parking.lot.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/spring/application-context.xml"})
public class TicketServiceTest {

    @Autowired
    TicketService ticketService;

    @Test
    public void iAmAbleToCreateAPoolMatch() {
      //  final Ticket result = ticketService.createTicket(1, LocalTime.parse("2018-11-11 22:22:22"),LocalTime.parse("2018-11-11 22:22:22"),false);

        //incomplete

    }
}