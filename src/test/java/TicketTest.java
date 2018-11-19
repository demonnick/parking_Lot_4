import com.parking.lot.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket(1,Time.valueOf("2018-11-11 22:22:22"),Time.valueOf("2018-11-11 22:22:22"),false);

    }


}