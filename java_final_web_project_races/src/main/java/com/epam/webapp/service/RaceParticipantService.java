package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.entity.RaceParticipant;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;

import java.util.List;

public class RaceParticipantService {

    private DaoHelperFactory factory;

    public RaceParticipantService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<RaceParticipant> getAllRaceParticipants() throws Exception {
        try(DaoHelper helper = factory.create()){
            AbstractDao<RaceParticipant> raceParticipantAbstractDao = (AbstractDao<RaceParticipant>) helper.createRaceParticipantDao();
            return raceParticipantAbstractDao.getAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
