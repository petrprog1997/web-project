package com.epam.webapp.command;

import com.epam.webapp.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
