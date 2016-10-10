package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.entity.UserEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author A.Tymchenko
 * @version 1.0, 22.12.2015.
 */

/**
 * Command for Login execution (on Button Press)
 */
class DoLoginCommand implements ICommand {
    // Fields
    // Concrete Logger
    private static Logger logger = Logger.getLogger(DoLoginCommand.class.getName());
    private String errorMessage = "";

    // Methods

    /**
     * Generates hash of a password from form-input
     * Some magic to satisfy DB engines MD5()
     *
     * @param password password to hash
     * @return password hashcode
     */
    private String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                String hex = Integer.toHexString((int) 0x00FF & b);
                if (hex.length() == 1) {
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * If user already logged in redirects to page according to user role.
     * If not, searches user through DAO by name and checks hashes,
     * redirects to appropriate page.
     * If failed redirects to login page with error message
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        HttpSession session = request.getSession(false);
        // Tiny bit of logging
        logger.debug("Session:  " + session);

        if (UserChecker.checkUser(request, USER_ROLE_ID) != null) {
            return "redirect:/main";
        } else if (UserChecker.checkUser(request, ADMIN_ROLE_ID) != null) {
            return "redirect:/admin";
        } else {

            // Body
            String username = request.getParameter("username");
            UserEntity userEntity = daoFactory.getUserDAO().findUserByName(username);

            if (userEntity != null) {
                String password = request.getParameter("password");

                if (userEntity.getPassword().equals(hashPassword(password))) {

                    if (userEntity.isActive()) {
                        session = request.getSession(true);
                        session.setAttribute("user", userEntity);

                        if (userEntity.getRoleId().equals(USER_ROLE_ID)) {
                            return "redirect:/main";
                        } else if (userEntity.getRoleId().equals(ADMIN_ROLE_ID)) {
                            return "redirect:/admin";
                        } else {
                            return "redirect:/";
                        }
                    } else {
                        errorMessage = "Inactive User!";
                        request.setAttribute("errorMessage", errorMessage);
                        return "WEB-INF/jsp/index.jsp";
                    }
                }
            }

            errorMessage = "Invalid Login or Password!";
            request.setAttribute("errorMessage", errorMessage);
            return "WEB-INF/jsp/index.jsp";
            // -End of body-
        }
    }
}
