import com.parking.lot.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void initialize() {
        ticket = new Ticket(10, Time.valueOf("02:00:00"), Time.valueOf("12:00:00"), false, 30, 1);
    }


    @Test
    public void shouldCreateTicketWithParameters() {
        assertEquals(ticket, ticket);
    }

    @Test
    public void ensureCostIsCorrect() {
        int result = ticket.getCost();
        assertEquals(ticket.getCost(), result);
    }
}