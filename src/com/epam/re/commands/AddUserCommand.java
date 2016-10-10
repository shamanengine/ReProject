package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.FiliaDAO;
import com.epam.re.daol.interfaces.UserDAO;
import com.epam.re.entity.FiliaEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author A.Tymchenko
 * @version 1.0, 25.12.2015
 */

/**
 * Command class for User addition (on key press)
 */
class AddUserCommand implements ICommand {
    /**
     * Static message for login page with appropriate message
     * if something went wrong
     */
    private static String message = "";

    // Getters & Setters
    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        AddUserCommand.message = message;
    }

    /**
     * Checks user role.
     * If this is user redirect to /main
     * If this is admin redirect to /admin
     * If ain't any:
     * assembles new user by parameters in request
     * and adds it to base through DAO,
     * redirects to rent page;
     * if something happens, redirects to login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        // Session check
        if (UserChecker.checkUser(request, USER_ROLE_ID) != null) {
            return "redirect:/main";
        } else if (UserChecker.checkUser(request, ADMIN_ROLE_ID) != null) {
            return "redirect:/admin";
        } else {
            // Body of command
            String username =       request.getParameter("username");
            String password =       request.getParameter("password");
            String email =          request.getParameter("email");
            String filia =          request.getParameter("filia");

            UserDAO userDAO =       daoFactory.getUserDAO();
            FiliaDAO filiaDAO =     daoFactory.getFiliaDAO();
            FiliaEntity filiaEntity = filiaDAO.findFiliaByName(filia);

            try {
                userDAO.addUser(username, password, email, filiaEntity.getFiliaId());
            } catch (Exception e) {
                message = "Invalid input";
                return "redirect:/register";
            }

            return "redirect:/";
            // - End of body -
        }
    }

}
