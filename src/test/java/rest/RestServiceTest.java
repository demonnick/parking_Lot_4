package rest;

import com.parking.lot.Ticket;
import com.parking.lot.rest.TicketRestService;
import com.parking.lot.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class RestServiceTest {


    private Ticket ticket;

    @Mock
    private TicketService ticketService;

    private TicketRestService ticketRestService;

    private Ticket mock = new Ticket(10, Time.valueOf("02:00:00"), Time.valueOf("12:00:00"), false, 30, 1);


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(ticketService.getAllTickets())
                .thenReturn(Arrays.asList(new Ticket(10, Time.valueOf("02:00:00"), Time.valueOf("12:00:00"), false, 30, 1)));

        ticketRestService = new TicketRestService(ticketService);
    }

    @Test
    public void whenGettingAllTickets_TheValuesAreCorrect() {
        List<Ticket> t = ticketRestService.getAll();
        Ticket result = t.get(0);

        assertEquals(mock.getID(), result.getID());
        assertEquals(mock.getCost(), result.getCost());
        assertEquals(mock.getTime_out(), result.getTime_out());

    }
}
    


