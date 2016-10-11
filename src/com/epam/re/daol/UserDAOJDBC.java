package com.epam.re.daol;

import com.epam.re.daol.interfaces.UserDAO;
import com.epam.re.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author A.Tymchenko
 * @version 1.0, 22.12.2015.
 */

/**
 * JDBC implementation for user DAO
 *
 * @see com.epam.re.daol.interfaces.UserDAO
 * @see com.epam.re.entity.UserEntity
 */
class UserDAOJDBC implements UserDAO {
    // Constants
    private static final String SQL_FIND_USER_BY_NAME =
            "SELECT USER_ID, ROLE_ID, IS_ACTIVE, FILIA_ID, USERNAME_C, PASSWORD_C, EMAIL_C " +
                    "FROM T_USER " +
                    "WHERE USERNAME_C = ? " +
                    "LIMIT 1;";

    private static final String SQL_CHANGE_USER_STATUS_BY_ID =
            "UPDATE " +
                    "T_USER " +
                    "SET " +
                    "IS_ACTIVE = NOT(IS_ACTIVE) " +
                    "WHERE " +
                    "USER_ID = ?;";

    private static final String SQL_INSERT_USER =
            "INSERT INTO T_USER (ROLE_ID, IS_ACTIVE, FILIA_ID, USERNAME_C, PASSWORD_C, EMAIL_C) " +
                    "VALUES (2, false, ?, ?, MD5(?), ?);";

    // Fields
    private DAOFactory daoFactory;

    // Constructors
    public UserDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    // Methods
    @Override
    public UserEntity findUserByName(String username) {
        UserEntity userEntity = null;

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_NAME)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userEntity = new UserEntity();
                userEntity.setUserId(resultSet.getInt(1));
                userEntity.setRoleId(resultSet.getInt(2));
                userEntity.setActive(resultSet.getBoolean(3));
                userEntity.setFiliaId(resultSet.getInt(4));
                userEntity.setUsername(resultSet.getString(5));
                userEntity.setPassword(resultSet.getString(6));
                userEntity.setEmail(resultSet.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userEntity;
    }

    @Override
    public void changeUserStatusByID(Integer userId) {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_CHANGE_USER_STATUS_BY_ID)) {
            statement.setInt(1, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(String username, String password, String email, Integer filiaId) throws Exception {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER)) {

            statement.setInt(1, filiaId);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Base_exception");
        }

    }

}
