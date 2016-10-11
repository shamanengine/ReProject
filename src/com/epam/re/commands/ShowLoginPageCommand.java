package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Raccoon
 * @version 1.0, 22.12.2015.
 */

/**
 * Command for login page exposure
 */
class ShowLoginPageCommand implements ICommand {
    /**
     * Checks whether there is a user/ admin in request,
     * if so, redirects to appropriate page;
     * if not, sets an error message and returns login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
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
