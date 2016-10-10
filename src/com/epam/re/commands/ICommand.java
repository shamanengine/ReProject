package com.epam.re.commands;

import com.epam.re.daol.DAOFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015.
 */

/**
 * Interface for all commands
 */
public interface ICommand {
    // Constants
    /**
     * Constant for Admin role id = {@value}.
     */
    int ADMIN_ROLE_ID = 1;

    /**
     * Constant for User role id = {@value}.
     */
    int USER_ROLE_ID = 2;

    /**
     * Constant for log4j usage. prints ICommand class name.
     * If needed in other Command - declare explicitly.
     */
    Logger logger = Logger.getLogger(ICommand.class.getName());

    /**
     * Returns View(JSP) name
     *
     * @param request - HttpServletRequest for the command.
     * @param response  - HttpServletResponse for the command.
     * @param daoFactory - DAOFactory for this command.
     * @return String representation of View(JSP) name.
     */
    String execute(HttpServletRequest request, HttpServletResponse response, DAOFactory daoFactory);
}
