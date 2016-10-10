package com.epam.re.daol.interfaces;

import com.epam.re.entity.UserEntity;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */
public interface UserDAO {

    UserEntity findUserByName(String username);

    void changeUserStatusByID(Integer userId);

    void addUser(String username, String password, String email, Integer filiaId) throws Exception;

}
