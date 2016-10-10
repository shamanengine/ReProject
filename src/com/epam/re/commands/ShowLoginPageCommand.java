package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */

/**
 * Command for main page exposure
 */
class ShowLoginPageCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        if (UserChecker.checkUser(request, USER_ROLE_ID) != null) {
            return "redirect:/main";
        } else if (UserChecker.checkUser(request, ADMIN_ROLE_ID) != null) {
            return "redirect:/admin";
        } else {
            // Body
            String errorMessage = "Please enter your account information and login, or register a new one.";
            request.setAttribute("errorMessage", errorMessage);

            return "WEB-INF/jsp/index.jsp";
            // --
        }
    }

}
