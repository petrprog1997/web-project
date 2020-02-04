package com.epam.webapp.dao;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.connection.ProxyConnection;
import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.io.IOException;
import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws IOException, ServiceException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public BetDao createBetDao() {return new BetDaoImpl(connection);}

    public RunDao createRunDao() {return new RunDaoImpl(connection);}

    public RunParticipantDao createRunParticipantDao() {return new RunParticipantDaoImpl(connection);}

    public RaceParticipantDao createRaceParticipantDao() {return new RaceParticipantDaoImpl(connection);}

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
