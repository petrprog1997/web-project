package com.epam.webapp.builder;

import com.epam.webapp.entity.RaceParticipant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceParticipantRowMapper implements RowMapper<RaceParticipant> {

    @Override
    public RaceParticipant map(ResultSet resultSet) throws SQLException {
        String horseName = resultSet.getString(RaceParticipant.HORSE_NAME);
        int runNumber = resultSet.getInt(RaceParticipant.RACE_NUMBER);
        return new RaceParticipant(horseName,runNumber);
    }

    @Override
    public List<Object> getFieldsToSave(RaceParticipant item) {
        List<Object> objectsToSave = new ArrayList<>();
        objectsToSave.add(item.getHorseName());
        objectsToSave.add(item.getRunNumber());
        return objectsToSave;
    }
}
