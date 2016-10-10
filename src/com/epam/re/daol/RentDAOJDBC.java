package com.epam.re.daol;

import com.epam.re.daol.interfaces.RentDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */

/**
 * JDBC implementation for rent DAO
 */
class RentDAOJDBC implements RentDAO {
    // Constants
    private static final String SQL_INSERT_RENT =
            "INSERT INTO T_RENT " +
                    "(USER_ID, ONM_ID, CONTRACTOR_C, SQUARE_N, RENT_N, START_D, END_D) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

    // Fields
    private DAOFactory daoFactory;

    // Constructors
    public RentDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Adds a new rent, all params like in DB
     *
     * @param userId
     * @param onmId
     * @param contractor
     * @param square
     * @param rent
     * @param startD
     * @param endD
     * @throws Exception
     */
    @Override
    public void addRent(
            Integer userId, Integer onmId, String contractor,
            BigDecimal square, BigDecimal rent, Date startD, Date endD)
            throws Exception {

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_RENT)) {

            statement.setInt(1, userId);
            statement.setInt(2, onmId);
            statement.setString(3, contractor);
            statement.setBigDecimal(4, square);
            statement.setBigDecimal(5, rent);
            statement.setDate(6, (java.sql.Date) startD);
            statement.setDate(7, (java.sql.Date) endD);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Base_exception");
        }

    }
}
