package com.epam.webapp.command;

import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;
import com.mysql.cj.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {


    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String error = "Incorrect login or password";
        HttpSession session;
        Optional<User> optionalUser = userService.login(login, password);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            session = request.getSession();
            session.setAttribute("role",user.getUserType());
            session.setAttribute("login",user.getUserLogin());
            return CommandResult.redirect("/controller?command=mainPage");
        } else {
            request.setAttribute("errorMessage",error);
            return CommandResult.redirect("/controller?command=loginPage");
        }
    }
}
