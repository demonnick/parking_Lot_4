package com.parking.lot.dao;

/**
 * A DAO representing the interaction with the Fee structure and Lot table.
 */

public class LotDao {

        public static final String GET_FEE_STRUCTURE = "SELECT (LOT_ID, TIME, START_TIME, END_TIME, PRICE) FROM FEE_STRUCTURE";
        public static final String UPDATE_FEE_STRUCTURE = "UPDATE FEE_STRUCTURE";
}
