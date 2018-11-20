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
public class ParkingLotDao {

    public static final String SELECT_ALL_TICKETS = "SELECT  ID, TIME_IN TIME, TIME_OUT TIME, IS_LOST BOOLEAN FROM TICKET";
    public static final String SELECT_SINGLE_TICKET = "SELECT  ID, TIME_IN TIME, TIME_OUT TIME, IS_LOST BOOLEANFROM TICKET WHERE ID = ?";
    public static final String CREATE_TICKET = "INSERT INTO TICKET (ID,TIME_IN,TIME_OUT,IS_LOST) VALUES(?, ?, ?, ?)";

    private JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper = new RowMapper<Ticket>() {
        @Override
        public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
            Ticket result = new Ticket(
                    resultSet.getInt("ID"),
                    resultSet.getTime("TIME_IN").toLocalTime(),
                    resultSet.getTime("TIME_OUT").toLocalTime(),
                    resultSet.getBoolean("IS_LOST"));


            return result;
        }
    };




    public ParkingLotDao(DataSource dataSource) {
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
}