package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.exception.ServiceException;

import java.io.IOException;

public class DaoHelperFactory {

    public DaoHelper create() throws IOException, ServiceException {
        return new DaoHelper(ConnectionPool.getInstance());
    }

}
