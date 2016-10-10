package com.epam.re.daol;

import com.epam.re.daol.interfaces.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */

/**
 * DAOFactory, Lazy Singleton
 * Contains bunch of methods to get DAO of certain type
 */
public class DAOFactory {
    // Fields
    private static DAOFactory daoFactory;
    private DataSource dataSource;

    /**
     * Lazy Singleton
     *
     * @return instance of DAOFactory
     */
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    /**
     * Private constructor to deny outside explicit call to Constructor.
     * Sets DataSource
     */
    private DAOFactory() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/redb1");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets connection with datasource
     *
     * @return Connection with datasource
     * @throws SQLException
     */
    Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public FiliaDAO getFiliaDAO() {
        return new FiliaDAOJDBC(this);
    }

    public UserDAO getUserDAO() {
        return new UserDAOJDBC(this);
    }

    public MasterViewDAO getMasterViewDAO() {
        return new MasterViewDAOJDBC(this);
    }

    public OnmDAO getOnmDAO() {
        return new OnmDAOJDBC(this);
    }

    public RentDAO getRentDAO() {
        return new RentDAOJDBC(this);
    }

    public AllUsersViewDAO getAllUsersViewDAO() {
        return new AllUsersViewDAOJDBC(this);
    }

}
