package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import com.epam.re.daol.interfaces.MasterViewDAO;
import com.epam.re.dto.MasterView;
import com.epam.re.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author A.Tymchenko
 * @version 1.0, 23.12.2015.
 */

/**
 * Command for Main page exposure
 */
class ShowMainPageCommand implements ICommand {
    /**
     * Checks whether there is a user in request,
     * if so, gets users master view through DAO;
     * if not, redirects to login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        // We need userEntity to filter rents by it
        UserEntity user;

        if ((user = UserChecker.checkUser(request, USER_ROLE_ID)) != null) {
            // Body
            MasterViewDAO masterViewDAO = daoFactory.getMasterViewDAO();
            List<MasterView> masterViews = masterViewDAO.rentViewByUser(user);
            request.setAttribute("masterViews", masterViews);

            return "WEB-INF/jsp/main.jsp";
            // --
        } else {
            return "redirect:/";
        }
    }

}
