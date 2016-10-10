package com.epam.re.daol;

import com.epam.re.daol.interfaces.FiliaDAO;
import com.epam.re.entity.FiliaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */
class FiliaDAOJDBC implements FiliaDAO {

    // Constants
    private static final String SQL_FIND_ALL =
            "SELECT " +
                    "FILIA_ID, " +
                    "TITLE_C " +
                    "FROM " +
                    "DIM_FILIA;";

    private static final String SQL_FIND_FILIA_BY_NAME =
            "SELECT " +
                        "FILIA_ID, " +
                        "TITLE_C " +
                    "FROM " +
                        "DIM_FILIA " +
                    "WHERE " +
                        "TITLE_C = ?;";

    // Fields
    private DAOFactory daoFactory;

    // Constructor
    public FiliaDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<FiliaEntity> findAll() {
        List<FiliaEntity> filias = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FiliaEntity filia = new FiliaEntity();
                filia.setFiliaId(resultSet.getInt(1));
                filia.setTitle(resultSet.getString(2));
                filias.add(filia);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filias;
    }

    @Override
    public FiliaEntity findFiliaByName(String filiaName) {
        FiliaEntity filiaEntity = new FiliaEntity();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_FILIA_BY_NAME)) {
            statement.setString(1, filiaName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                filiaEntity.setFiliaId(resultSet.getInt("FILIA_ID"));
                filiaEntity.setTitle(resultSet.getString("TITLE_C"));
            } else {
                throw new Exception("Nothing in the Result Set");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        return filiaEntity;
    }
}
