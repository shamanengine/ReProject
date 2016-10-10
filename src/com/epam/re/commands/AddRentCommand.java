package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.OnmDAO;
import com.epam.re.daol.interfaces.RentDAO;
import com.epam.re.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author A.Tymchenko
 * @version 1.0, 24.12.2015
 */

/**
 * Command class for Rent addition (on key press)
 */
class AddRentCommand implements ICommand {
    /**
     * Message for page if something went wrong
     */
    private static String message = "";

    // Getters & Setters
    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        AddRentCommand.message = message;
    }

    // Methods

    /**
     * Checks user role.
     * If appropriate:
     * assembles new rent by parameters in request
     * and adds it to base through DAO,
     * redirects to rent page;
     * <p>
     * if not:
     * redirects to main page;
     * <p>
     * if there no user in {@code HttpServletRequest}:
     * redirects to login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        // Session check
        UserEntity user;

        if ((user = UserChecker.checkUser(request, USER_ROLE_ID)) != null) {
            try {
                // Body of command, dealing with:
                // 1 column
                Integer userId = user.getUserId();

                // 2 column
                String address = request.getParameter("address");
                OnmDAO onmDAO = daoFactory.getOnmDAO();
                Integer onmId = onmDAO.findOnmByAddress(address).getOnmId();

                // 3 - 7 columns
                String contractor = request.getParameter("contractor");
                BigDecimal square = new BigDecimal(request.getParameter("square"));
                BigDecimal rent = new BigDecimal(request.getParameter("rent"));
                Date startD = Date.valueOf(request.getParameter("startD"));
                Date endD = Date.valueOf(request.getParameter("endD"));

                // adding a rent
                RentDAO rentDAO = daoFactory.getRentDAO();
                rentDAO.addRent(userId, onmId, contractor, square, rent, startD, endD);
            } catch (Exception e) {
                message = "Invalid input";
                return "redirect:/main/rent";
                // - End of body -
            }

            return "redirect:/main";
        } else {
            return "redirect:/";
        }
    }
}