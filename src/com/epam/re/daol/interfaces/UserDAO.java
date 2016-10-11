package com.epam.re.daol.interfaces;

import com.epam.re.entity.UserEntity;

/**
 * @author A.Tymchenko
 * @version 1.0, 22.12.2015.
 */

/**
 * DAO interface to access user entity representation
 *
 * @see com.epam.re.entity.UserEntity
 */
public interface UserDAO {

    /**
     * Searches fo the user by his name
     *
     * @param username name of the user by which search is performed
     * @return {@code UserEntity}, user representation with specified name
     */
    UserEntity findUserByName(String username);

    /**
     * Activates/ deactivates user with specified id
     *
     * @param userId id of the user for which to change status
     */
    void changeUserStatusByID(Integer userId);

    /**
     * Adds a new (inactive) user
     *
     * @param username name of the user
     * @param password password for the user
     * @param email    user's email
     * @param filiaId  id of the filia (region) in which user is registered
     * @throws Exception
     */
    void addUser(String username, String password, String email, Integer filiaId) throws Exception;

}
