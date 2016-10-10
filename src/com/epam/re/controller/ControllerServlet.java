package com.epam.re.controller;

import com.epam.re.commands.CommandExecutor;
import com.epam.re.commands.ICommand;
import com.epam.re.daol.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015.
 */

/**
 * Front-Controller
 */
public class ControllerServlet extends HttpServlet {
    // Fields
    private DAOFactory daoFactory;

    // Standard methods
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes all requests (Master-method).
     * Searches for the command, executes it,
     * gets name of the view to expose, shows it
     *
     * @param request  - HttpServletRequest for processing
     * @param response - HttpServletResponse for processing
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ICommand command = CommandExecutor.findCommand(request, response);
        String viewName = command.execute(request, response, daoFactory);
        showView(request, response, viewName);
    }

    /**
     * Shows view
     *
     * @param request  - HttpServletRequest for processing
     * @param response - HttpServletResponse for processing
     * @param viewName String representation of View to show
     * @throws ServletException
     * @throws IOException
     */
    private void showView(HttpServletRequest request, HttpServletResponse response, String viewName)
            throws ServletException, IOException {
        if (viewName.contains("redirect:")) {
            response.sendRedirect(viewName.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(viewName).forward(request, response);
        }
    }

    @Override
    public void init() throws ServletException {
        // super.init(); - under the hood
        daoFactory = DAOFactory.getInstance();
    }
}
