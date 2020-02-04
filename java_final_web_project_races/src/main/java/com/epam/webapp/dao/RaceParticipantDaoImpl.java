package com.epam.webapp.dao;

import com.epam.webapp.builder.RaceParticipantRowMapper;
import com.epam.webapp.entity.RaceParticipant;
import java.sql.Connection;
import java.util.Optional;

public class RaceParticipantDaoImpl extends AbstractDao<RaceParticipant> implements RaceParticipantDao {

    private final String FIND_BY_ID = "select * from " + RaceParticipant.TABLE + " where " + RaceParticipant.ID + "= ?";
    private final String FIND_BY_HORSE_NAME = "select * from " + RaceParticipant.TABLE + " where " +
            RaceParticipant.HORSE_NAME + "= ?";
    private final String FIND_BY_NUMBER = "select * from " + RaceParticipant.TABLE + " where " +
            RaceParticipant.RACE_NUMBER + "= ?";
    private final String REMOVE_BY_ID = "delete from " + RaceParticipant.TABLE + " where " + RaceParticipant.ID + "= ?";
    private final String SAVE_RACE_PARTICIPANT = "insert into " + RaceParticipant.TABLE + "(" +
            RaceParticipant.HORSE_NAME +", " + RaceParticipant.RACE_NUMBER + "VALUES(?, ?)";

    public RaceParticipantDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return RaceParticipant.TABLE;
    }

    @Override
    public Optional<RaceParticipant> findById(Long id) {
        return executeForSingleResult(FIND_BY_ID, new RaceParticipantRowMapper(), id);
    }

    @Override
    public Optional<RaceParticipant> findByHorseName(String horseName) {
        return executeForSingleResult(FIND_BY_HORSE_NAME, new RaceParticipantRowMapper(), horseName);
    }

    @Override
    public Optional<RaceParticipant> findByRaceNumber(int raceNumber) {
        return executeForSingleResult(FIND_BY_NUMBER, new RaceParticipantRowMapper(), raceNumber);
    }

    @Override
    public void removeById(Long id) {
        executeUpdate(REMOVE_BY_ID, id);
    }

    @Override
    public void save(RaceParticipant entity) {
        executeUpdateForSave(entity,SAVE_RACE_PARTICIPANT);
    }


}
