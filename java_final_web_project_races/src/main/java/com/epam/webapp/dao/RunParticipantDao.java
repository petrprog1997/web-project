package com.epam.webapp.dao;

import com.epam.webapp.entity.RunParticipant;

import java.util.List;
import java.util.Optional;

public interface RunParticipantDao extends Dao<RunParticipant> {

    Optional<RunParticipant> findByHorseName(String horseName);

    Optional<RunParticipant> findByRunPlace(int runPlace);

    Optional<RunParticipant> findByRaceNumber(int raceNumber);

    void save(List<RunParticipant> entities);
}


