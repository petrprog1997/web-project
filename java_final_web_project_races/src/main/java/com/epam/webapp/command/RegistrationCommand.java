package com.epam.webapp.command;

import com.epam.webapp.entity.User;
import com.epam.webapp.entity.UserStatus;
import com.epam.webapp.entity.UserType;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String strType = request.getParameter("type");
        UserType userType = UserType.valueOf(strType);
        UserStatus userStatus = UserStatus.ACTIVE;
        User user = new User(login,password,userStatus ,userType,0);
        userService.registration(user);
        return CommandResult.redirect("/controller?command=mainPage");
    }
}
