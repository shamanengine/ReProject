package com.epam.re.daol.interfaces;

import com.epam.re.dto.AllUsersView;

import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015
 */

/**
 * DAO interface to access views for all users representation
 *
 * @see com.epam.re.dto.AllUsersView
 */
public interface AllUsersViewDAO {
    /**
     * Gets {@code List} of views of all users
     *
     * @return {@code List} of views of all users
     */
    List<AllUsersView> findAll();

}
