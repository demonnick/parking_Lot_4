package com.parking.lot.dao;

import com.parking.lot.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * A DAO representing the interaction with the PARKING table.
 */
public class TicketDao {

    public static final String SELECT_ALL_TICKETS = "SELECT  ID, TIME_IN TIME, TIME_OUT TIME, IS_LOST BOOLEAN,COST,LOT INTEGER FROM TICKET";
    public static final String SELECT_SINGLE_TICKET = "SELECT  ID, TIME_IN TIME, TIME_OUT TIME, IS_LOST BOOLEAN ,COST,LOT INTEGER FROM TICKET WHERE ID = ?";
    public static final String CREATE_TICKET = "INSERT INTO TICKET (ID,TIME_IN,TIME_OUT,IS_LOST,COST,LOT ) VALUES(?, ?, ?, ?,?, ?)";
    private final String UPDATE_TICKET = "UPDATE TICKET SET TIME_OUT = ?, IS_LOST = ?, COST = ? where ID = ?";


    private JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper = new RowMapper<Ticket>() {
        @Override
        public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
            Ticket result = new Ticket(
                    resultSet.getInt("ID"),
                    resultSet.getTime("TIME_IN"),
                    resultSet.getTime("TIME_OUT"),
                    resultSet.getBoolean("IS_LOST"),
                    resultSet.getInt("COST"),
                    resultSet.getInt("LOT"));

            return result;
        }
    };


    public TicketDao(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    /**
     * Retrieve all the tickets from the database.
     *
     * @return a {@link List} of all {@link Ticket}
     */
    public List<Ticket> getTickets() {
        return jdbcTemplate.query(SELECT_ALL_TICKETS, ticketRowMapper);
    }

    /**
     * Return a ticket for a given id.
     *
     * @param id the id of the ticket
     * @return the {@link Ticket} for the id.
     */
    public Ticket getTicket(int id) {
        return jdbcTemplate.queryForObject(SELECT_SINGLE_TICKET,
                new Object[]{id},
                ticketRowMapper);
    }

    /**
     * Create a ticket in the database.
     */
    public void createTicket(Ticket ti) {

        jdbcTemplate.update(CREATE_TICKET, new Object[]{ti.getID(), ti.getTime_in(), ti.getTime_out(), ti.getIs_lost(), ti.getCost(), ti.getLot()});
    }

    /**
     * Update a ticket in the database.
     */
    public void updateTicket(Ticket ticket) {

        jdbcTemplate.update(UPDATE_TICKET, new Object[]{ticket.getTime_out(), ticket.getIs_lost(), ticket.getCost(), ticket.getID()});
    }


}
