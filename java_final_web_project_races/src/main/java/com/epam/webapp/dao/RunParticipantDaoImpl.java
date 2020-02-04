package com.epam.webapp.dao;

import com.epam.webapp.builder.RunParticipantRowMapper;
import com.epam.webapp.entity.RaceParticipant;
import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunParticipant;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RunParticipantDaoImpl extends AbstractDao<RunParticipant> implements RunParticipantDao {

    private final String FIND_BY_ID = "select * from " + RunParticipant.TABLE + " where " + RunParticipant.ID + "= ?";
    private final String FIND_HORSE_NAME= "select * from " + RunParticipant.TABLE +" where " +
            RunParticipant.HORSE_NAME + "= ?";
    private final String FIND_BY_RACE_NUMBER = "select * from " + RunParticipant.TABLE + " where " +
            RunParticipant.RACE_NUMBER +"= ?";
    private final String FIND_BY_RUN_PLACE = "select * from " + RunParticipant.TABLE + " where " +
            RunParticipant.RUN_PLACE +"= ?";
    private final String REMOVE_BY_ID = "delete from " + RunParticipant.TABLE + " where " + RunParticipant.RUN_ID + "= ?";
    private final String SAVE_RUN_PARTICIPANT = "insert into " + RunParticipant.TABLE + "(" +
           RunParticipant.RUN_ID + ", " + RunParticipant.HORSE_NAME +", " + RunParticipant.RACE_NUMBER + ", " + RunParticipant.RUN_PLACE + ") "+ "VALUES(?, ?, ?, ?);";

    public RunParticipantDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return RunParticipant.TABLE;
    }

    @Override
    public Optional<RunParticipant> findById(Long id) {
        return executeForSingleResult(FIND_BY_ID, new RunParticipantRowMapper(), id);
    }

    @Override
    public Optional<RunParticipant> findByHorseName(String horseName) {
        return executeForSingleResult(FIND_HORSE_NAME, new RunParticipantRowMapper(), horseName);
    }

    @Override
    public Optional<RunParticipant> findByRaceNumber(int raceNumber) {
        return executeForSingleResult(FIND_BY_RACE_NUMBER, new RunParticipantRowMapper(),raceNumber);
    }

    @Override
    public Optional<RunParticipant> findByRunPlace(int runPlace) {
        return executeForSingleResult(FIND_BY_RUN_PLACE, new RunParticipantRowMapper(),runPlace);
    }

    @Override
    public void removeById(Long id) {
        executeUpdate(REMOVE_BY_ID, id);
    }

    @Override
    public void save(RunParticipant entity) {
        executeUpdateForSave(entity,SAVE_RUN_PARTICIPANT);
    }

    public void save(List<RunParticipant> entities) {
        for(RunParticipant entity : entities) {
            executeUpdateForSave(entity,SAVE_RUN_PARTICIPANT);
        }
    }


}
