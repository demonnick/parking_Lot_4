package com.parking.lot.dao;

import com.parking.lot.FeeStructure;
import com.parking.lot.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * A DAO representing the interaction with the Fee structure and Lot table.
 */

public class LotDao {

    public static final String GET_FEE_STRUCTURE = "SELECT (LOT_ID, TIME, START_TIME, END_TIME, PRICE) FROM FEE_STRUCTURE";
    public static final String UPDATE_FEE_STRUCTURE = "UPDATE FEE_STRUCTURE SET TIME_INFO = ?, START_TIME = ?, END_TIME = ?, PRICE = ?";

    private JdbcTemplate jdbcTemplate;
    private final RowMapper<FeeStructure> lotRowMapper = new RowMapper<FeeStructure>() {
        @Override
        public FeeStructure mapRow(ResultSet resultSet, int i) throws SQLException {
            FeeStructure result = new FeeStructure(
                    resultSet.getInt("LOT_ID"),
                    resultSet.getString("TIME"),
                    resultSet.getInt("START_TIME"),
                    resultSet.getInt("END_TIME"),
                    resultSet.getInt("PRICE"),
                    resultSet.getInt("FEE_ID"));

            return result;
        }
    };

    public LotDao(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Retrieve the fee structure from the database.
     *
     * @return a {@link List} of all {@link FeeStructure}
     */
    public List<FeeStructure> getFeeStructure() {
        return jdbcTemplate.query(GET_FEE_STRUCTURE, lotRowMapper);
    }

    /**
     * Update a Fee Structure in the database.
     */
    public void updateTicket(FeeStructure feeStructure) {

        jdbcTemplate.update(UPDATE_FEE_STRUCTURE, new Object[]{feeStructure.getTime(),feeStructure.getStart(), feeStructure.getEnd(), feeStructure.getPrice()});
    }
}

