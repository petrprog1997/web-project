package com.epam.webapp.service;

import com.epam.webapp.dao.*;
import com.epam.webapp.entity.RaceParticipant;
import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.exception.ServiceException;

import java.io.IOException;
import java.util.List;

public class RunService {

    private DaoHelperFactory factory;

    public RunService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<Run> getAllRuns() throws Exception {
        try(DaoHelper helper = factory.create()){
            AbstractDao<Run> runAbstractDao = (AbstractDao<Run>) helper.createRunDao();
            return runAbstractDao.getAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void addRun(Run run) throws IOException, ServiceException {
        try (DaoHelper helper = factory.create()) {
            RunDao runDao = helper.createRunDao();
            runDao.save(run);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void deleteRun(Long id) throws IOException, ServiceException {
        try (DaoHelper helper = factory.create()) {
            RunDao runDao = helper.createRunDao();
            runDao.removeById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
