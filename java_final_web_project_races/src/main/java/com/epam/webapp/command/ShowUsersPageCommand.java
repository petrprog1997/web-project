package com.epam.webapp.command;

import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUsersPageCommand implements Command {

    private UserService userService;

    public ShowUsersPageCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = userService.getAllUsers();
        request.setAttribute("users",userList);

        return CommandResult.forward("/jsp/usersPage.jsp");
    }
}
