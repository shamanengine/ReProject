package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author A.Tymchenko
 * @version 1.0, 24.12.2015
 */

/**
 * Command for user status change(active/ inactive)
 */
class ChangeUserStatusCommand implements ICommand {
    /**
     * If admin in request switches user status,
     * else redirects to login page
     *
     * @param request - HttpServletRequest for the command.
     * @param response  - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        if (UserChecker.checkUser(request, ADMIN_ROLE_ID) != null) {
            // Body
            Integer userId =    Integer.parseInt(request.getParameter("userId"));
            UserDAO userDAO =   daoFactory.getUserDAO();
            userDAO.changeUserStatusByID(userId);

            return "redirect:/admin/all-users";
            // - End of body -
        } else {
            return "redirect:/";
        }
    }

}
