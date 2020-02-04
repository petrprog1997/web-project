package com.epam.webapp.controller;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFactory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.exception.UnknownCommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String stringCommand = request.getParameter("command");
        try {
            Command command = CommandFactory.create(stringCommand);
            CommandResult result = command.execute(request,response);
            if(result.isRedirect()) {
                response.sendRedirect(request.getContextPath() + result.getPage());
            }
            else {
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(result.getPage());
                requestDispatcher.forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (UnknownCommandException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
