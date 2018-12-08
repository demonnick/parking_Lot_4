package Dao;

import com.parking.lot.Ticket;
import com.parking.lot.dao.TicketDao;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicketDaoTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(locations = {
            "/spring/application-context.xml",
            "/spring/flyway-init.xml"})
    @TestExecutionListeners({
            DependencyInjectionTestExecutionListener.class,
            FlywayTestExecutionListener.class
    })
    @FlywayTest
    public class PoolMatchDaoTest {

        @Autowired
        TicketDao ticketDao;

        @Test
        public void canRetrieveTestDataFromDB() {
            List<Ticket> result = ticketDao.getTickets();
            assertEquals(10, result.size());
        }

        @Test
        public void canRetreiveASinglePoolMatch() {
            Ticket result = ticketDao.getTicket(1);
            assertEquals(0, result.getCost());

        }
    }


}
