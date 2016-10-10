package com.epam.re.daol;

import com.epam.re.daol.interfaces.MasterViewDAO;
import com.epam.re.dto.MasterView;
import com.epam.re.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */

/**
 * JDBC implementation for users masterview DAO
 */
class MasterViewDAOJDBC implements MasterViewDAO {

    // Contstants
    private static final String SQL_RENT_VIEW_BY_USER =
            "SELECT " +
                    "RENT_ID, " +
                    "ADDRESS_C, " +
                    "CONTRACTOR_C, " +
                    "SQUARE_N, " +
                    "RENT_N, " +
                    "START_D, " +
                    "END_D " +
                    "FROM " +
                    "MASTER_VIEW " +
                    "WHERE " +
                    "MASTER_VIEW.USER_ID = ?;";

    private static final String SQL_RENT_VIEW_ALL =
            "SELECT " +
                    "RENT_ID, " +
                    "TITLE_C, " +
                    "USERNAME_C, " +
                    "ADDRESS_C, " +
                    "CONTRACTOR_C, " +
                    "SQUARE_N, " +
                    "RENT_N, " +
                    "START_D, " +
                    "END_D " +
                    "FROM " +
                    "MASTER_VIEW;";

    // Fields
    private DAOFactory daoFactory;

    // Constructor
    public MasterViewDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Gets List of rent views for user
     *
     * @param userEntity user for whom rent view is built
     * @return List of rent views for user
     */
    @Override
    public List<MasterView> rentViewByUser(UserEntity userEntity) {
        List<MasterView> rentList = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_RENT_VIEW_BY_USER)) {
            statement.setInt(1, userEntity.getUserId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MasterView masterView = new MasterView();

                masterView.setRentId(resultSet.getInt("RENT_ID"));
                masterView.setAddress(resultSet.getString("ADDRESS_C"));
                masterView.setContractor(resultSet.getString("CONTRACTOR_C"));
                masterView.setSquare(resultSet.getBigDecimal("SQUARE_N"));
                masterView.setRent(resultSet.getBigDecimal("RENT_N"));
                masterView.setStartD(resultSet.getDate("START_D"));
                masterView.setEndD(resultSet.getDate("END_D"));

                rentList.add(masterView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentList;
    }

    /**
     * Gets list of all rent views
     *
     * @return List of all rent views
     */
    @Override
    public List<MasterView> rentViewAll() {
        List<MasterView> rentList = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_RENT_VIEW_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MasterView masterView = new MasterView();

                masterView.setRentId(resultSet.getInt("RENT_ID"));
                masterView.setTitle(resultSet.getString("TITLE_C"));
                masterView.setUsername(resultSet.getString("USERNAME_C"));
                masterView.setAddress(resultSet.getString("ADDRESS_C"));
                masterView.setContractor(resultSet.getString("CONTRACTOR_C"));
                masterView.setSquare(resultSet.getBigDecimal("SQUARE_N"));
                masterView.setRent(resultSet.getBigDecimal("RENT_N"));
                masterView.setStartD(resultSet.getDate("START_D"));
                masterView.setEndD(resultSet.getDate("END_D"));

                rentList.add(masterView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentList;
    }

}
