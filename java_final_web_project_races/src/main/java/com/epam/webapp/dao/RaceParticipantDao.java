package com.epam.webapp.dao;

import com.epam.webapp.entity.RaceParticipant;

import java.util.Optional;

public interface RaceParticipantDao {

    Optional<RaceParticipant> findByHorseName(String horseName);

    Optional<RaceParticipant> findByRaceNumber(int raceNumber);

}
