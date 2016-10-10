package com.epam.re.daol;

import com.epam.re.daol.interfaces.AllUsersViewDAO;
import com.epam.re.dto.AllUsersView;

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

class AllUsersViewDAOJDBC implements AllUsersViewDAO {

    // Contstants
    private static final String SQL_FIND_ALL_USERS =
            "SELECT * FROM VIEW_ALL_USERS;";

    // Fields
    private DAOFactory daoFactory;

    // Constructor
    public AllUsersViewDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<AllUsersView> findAll() {
        List<AllUsersView> usersViewList = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AllUsersView allUsersView = new AllUsersView();

                allUsersView.setUserId(resultSet.getInt(1));
                allUsersView.setRole(resultSet.getString(2));
                allUsersView.setActive(resultSet.getBoolean(3));
                allUsersView.setFilia(resultSet.getString(4));
                allUsersView.setUsername(resultSet.getString(5));
                allUsersView.setEmail(resultSet.getString(6));

                usersViewList.add(allUsersView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersViewList;
    }

}
