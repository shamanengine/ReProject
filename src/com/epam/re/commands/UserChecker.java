package com.epam.re.commands;

import com.epam.re.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author A.Tymchenko
 * @version 1.0, 04.01.2016
 */

/**
 * Helper class that contains method to check users permission
 * by request that came and role needed to pass the check
 */
public class UserChecker {
    /**
     * Checks whether user in current session has suitable role (by Id).
     *
     * @param request {@code HttpServletRequest} with user attribute to check
     * @param id      id of a role needed to pass the check
     * @return {@code UserEntity} if user in current session has suitable role (by Id),
     * else (if there is no user in session or user has not suitable role for this action) - {@code null}.
     */
    public static UserEntity checkUser(HttpServletRequest request, int id) {

        HttpSession session = request.getSession(false);
        UserEntity user;

        if (session != null
                && (user = (UserEntity) session.getAttribute("user")) != null
                && user.isActive()
                && user.getRoleId().equals(id)) {

            return user;
        } else {
            return null;
        }
    }
}
