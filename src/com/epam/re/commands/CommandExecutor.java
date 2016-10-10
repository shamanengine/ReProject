package com.epam.re.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author A.Tymchenko
 * @version 1.0, 21.12.2015
 */

/**
 * Class-helper for command execution;
 * Contains:
 * {@code Map} with all command aliases and corresponding implementations
 * Method to retrieving the command by its URI
 */
public class CommandExecutor {
    /**
     * {@code HashMap<String, ICommand>} which contains command aliases and corresponding implementations
     */
    private static Map<String, ICommand> commandMap = new HashMap<>();

    /**
     * Static initialization block to fill the {@code HashMap}
     */
    static {
        commandMap.put("/", new ShowLoginPageCommand());

        commandMap.put("/login", new DoLoginCommand());
        commandMap.put("/logout", new DoLogoutCommand());

        commandMap.put("/register", new ShowRegisterPageCommand());
        commandMap.put("/register/add-user", new AddUserCommand());

        commandMap.put("/main", new ShowMainPageCommand());
        commandMap.put("/main/rent", new ShowRentPageCommand());
        commandMap.put("/main/rent/add-rent", new AddRentCommand());

        commandMap.put("/admin", new ShowAdminPageCommand());
        commandMap.put("/admin/all-users", new ShowAllUsersCommand());
        commandMap.put("/admin/all-users/change-status", new ChangeUserStatusCommand());
    }

    /**
     * Searches for command by {@code String} URI in {@code HttpServletRequest}
     *
     * @param request  HttpServletRequest which contains URI of a command to return
     * @param response HttpServletResponse
     * @return command by its URI
     */
    public static ICommand findCommand(HttpServletRequest request, HttpServletResponse response) {
        String requestURI = request.getRequestURI();
        return commandMap.get(requestURI);
    }
}
