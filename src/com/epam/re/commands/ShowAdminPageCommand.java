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
 * Command for Admin page exposure
 */
class ShowAdminPageCommand implements ICommand {
    /**
     * Checks whether there is an admin in request,
     * if so, gets admin's master view through DAO;
     * if not, redirects to login page.
     *
     * @param request    - HttpServletRequest for the command.
     * @param response   - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory) {
        if (UserChecker.checkUser(request, ADMIN_ROLE_ID) != null) {
            // Body
            MasterViewDAO masterViewDAO = daoFactory.getMasterViewDAO();
            List<MasterView> masterViews = masterViewDAO.rentViewAll();
            request.setAttribute("masterViews", masterViews);

            return "WEB-INF/jsp/admin.jsp";
            // ----
        }

        return "redirect:/";
    }
}
