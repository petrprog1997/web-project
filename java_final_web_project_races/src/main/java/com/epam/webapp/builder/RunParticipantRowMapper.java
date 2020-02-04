package com.epam.webapp.builder;

import com.epam.webapp.entity.RunParticipant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunParticipantRowMapper implements RowMapper<RunParticipant> {

    @Override
    public RunParticipant map(ResultSet resultSet) throws SQLException {
        String horseName = resultSet.getString(RunParticipant.HORSE_NAME);
        int runNumber = resultSet.getInt(RunParticipant.RACE_NUMBER);
        int runPlace = resultSet.getInt(RunParticipant.RUN_PLACE);
        int runId =resultSet.getInt(RunParticipant.RUN_ID);
        return new RunParticipant(runId, horseName,runNumber,runPlace);
}

    @Override
    public List<Object> getFieldsToSave(RunParticipant item) {
        List<Object> objectsToSave = new ArrayList<>();
        objectsToSave.add(item.getRunId());
        objectsToSave.add(item.getHorseName());
        objectsToSave.add(item.getRunNumber());
        objectsToSave.add(item.getRunPlace());
        return objectsToSave;
    }
}
