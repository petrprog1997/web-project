package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.dao.RunParticipantDao;
import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.exception.ServiceException;

import java.io.IOException;
import java.util.List;

public class RunParticipantService {

    private DaoHelperFactory factory;

    public RunParticipantService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public void addRunParticipant(RunParticipant runParticipant) throws IOException, ServiceException {
        try (DaoHelper helper = factory.create()) {
            RunParticipantDao runDao = helper.createRunParticipantDao();
            runDao.save(runParticipant);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public List<RunParticipant> getAllRunParticipants() throws Exception {
        try(DaoHelper helper = factory.create()){
            AbstractDao<RunParticipant> userAbstractDao = (AbstractDao<RunParticipant>) helper.createRunParticipantDao();
            return userAbstractDao.getAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void deleteRunParticipant(Long runId) throws IOException, ServiceException {
        try (DaoHelper helper = factory.create()) {
            RunParticipantDao runDao = helper.createRunParticipantDao();
            runDao.removeById(runId);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
