package com.epam.webapp.command;

import com.epam.webapp.entity.UserStatus;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeUserStatusCommand implements Command {

    private UserService userService;

    public ChangeUserStatusCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("user");
        System.out.println(userId);
        int id = Integer.parseInt("1");
        userService.changeUserStatus(id);
        return CommandResult.redirect("/controller?command=usersPage");
    }
}
