import com.parking.lot.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void setUp() throws Exception {
        Ticket ticket = new Ticket(0,Time.valueOf("12:00:00"),Time.valueOf("12:00:00"),false,0);
    }


}