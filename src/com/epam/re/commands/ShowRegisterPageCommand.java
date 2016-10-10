package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.FiliaDAO;
import com.epam.re.entity.FiliaEntity;
import com.epam.re.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 22.12.2015.
 */

/**
 * Command for Register page exposure
 */
class ShowRegisterPageCommand implements ICommand {
    /**
     * Message for page if something went wrong
     */
    private static String externalMessage = "";
    private static String errorMail = "";

    // Getters & Setters
    /**
     * Returns message for usage outside this page.
     *
     * @return message that might be used outside this page.
     */
    public static String getExternalMessage() {
        return externalMessage;
    }

    /**
     * Sets message for usage outside this page.
     *
     * @param externalMessage message that might be used outside this page.
     */
    public static void setExternalMessage(String externalMessage) {
        ShowRegisterPageCommand.externalMessage = externalMessage;
    }

    /**
     * Shows page for registration.
     * If user in request (in session) already exists,
     * redirects to appropriate page
     *
     * @param request - HttpServletRequest for the command.
     * @param response  - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {

        HttpSession session = request.getSession(false);
        UserEntity user;

        if (session != null
                && (user = (UserEntity) session.getAttribute("user")) != null) {

                if (user.isActive()) {

                    if (user.getRoleId().equals(USER_ROLE_ID)) {
                        return "redirect:/main";
                    } else if (user.getRoleId().equals(ADMIN_ROLE_ID)) {
                        return "redirect:/admin";
                    } else {
                        externalMessage = "Inactive user!";
                        return "redirect:/";
                    }
                } else {
                    return "redirect:/";
                }

        } else {

            // Body
            FiliaDAO filiaDAO = daoFactory.getFiliaDAO();
            List<FiliaEntity> filias = filiaDAO.findAll();
            request.setAttribute("filias", filias);

            String message = "";
            if (AddUserCommand.getMessage().equals("")) {
                message = "Please wait for activation of your account after registration.";
            } else {
                message = "Invalid input";
                AddUserCommand.setMessage("");
            }

            request.setAttribute("errorMessage", message);

            return "WEB-INF/jsp/register.jsp";
            // - End of body -
        }
    }
}

