package com.epam.re.daol;

import com.epam.re.daol.interfaces.OnmDAO;
import com.epam.re.entity.FiliaEntity;
import com.epam.re.entity.OnmEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */
class OnmDAOJDBC implements OnmDAO {

    private static final String SQL_FIND_ONM_BY_ADDRESS =
            "SELECT " +
                    "ONM_ID, FILIA_ID, ADDRESS_C " +
            "FROM " +
                    "T_ONM " +
            "WHERE " +
                    "ADDRESS_C = ?" +
            "LIMIT 1;";

    private static final String SQL_FIND_ONM_BY_FILIA =
            "SELECT " +
                    "ONM_ID, FILIA_ID, ADDRESS_C " +
            "FROM " +
                    "T_ONM " +
            "WHERE " +
                    "FILIA_ID = ?";

    // Fields
    private DAOFactory daoFactory;

    // Constructor
    public OnmDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public OnmEntity findOnmByAddress(String address) {
        OnmEntity onmEntity = new OnmEntity();

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ONM_BY_ADDRESS)) {

            statement.setString(1, address);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                onmEntity.setOnmId(resultSet.getInt("ONM_ID"));
                onmEntity.setFiliaId(resultSet.getInt("FILIA_ID"));
                onmEntity.setAddress(resultSet.getString("ADDRESS_C"));
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

        return onmEntity;
    }

    @Override
    public List<OnmEntity> findOnmByFiliaId(Integer filiaId) {
        List<OnmEntity> onmList = new ArrayList<>();

        try (Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ONM_BY_FILIA)) {

            statement.setInt(1, filiaId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                OnmEntity onm = new OnmEntity();

                onm.setOnmId(resultSet.getInt("ONM_ID"));
                onm.setFiliaId(resultSet.getInt("FILIA_ID"));
                onm.setAddress(resultSet.getString("ADDRESS_C"));

                onmList.add(onm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }

        return onmList;
    }
}
