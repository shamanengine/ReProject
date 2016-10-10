package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.OnmDAO;
import com.epam.re.entity.OnmEntity;
import com.epam.re.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 27.12.2015
 */

/**
 * Command for page with rents exposure
 */
class ShowRentPageCommand implements ICommand {

    /**
     * Checks whether user in request has appropriate permissions:
     *
     * if so, sets {@code List<OnmEntity>} with real estate objects of this user through DAO;
     * redirects to rent page, where all this data is exposed.
     *
     * if not, redirects to login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        UserEntity user;

        if ((user = UserChecker.checkUser(request, USER_ROLE_ID)) != null) {
            // Body
            OnmDAO onmDAO = daoFactory.getOnmDAO();
            List<OnmEntity> onmList = onmDAO.findOnmByFiliaId(user.getFiliaId());
            request.setAttribute("onmList", onmList);
            request.setAttribute("message", AddRentCommand.getMessage());
            AddRentCommand.setMessage("");

            return "/WEB-INF/jsp/rent.jsp";
            // - End of body -
        } else {
            return "redirect:/";
        }
    }
}