package com.epam.webapp.builder;

import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunStatus;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunRowMapper implements RowMapper<Run> {
    @Override
    public Run map(ResultSet resultSet) throws SQLException {
        int runId = resultSet.getInt(Run.ID);
        String runDate = resultSet.getString(Run.RUN_DATE);
        String strRunStatus = resultSet.getString(Run.RUN_STATUS);
        RunStatus runStatus = RunStatus.valueOf(strRunStatus);
        int runWinner =  resultSet.getInt(Run.RUN_WINNER);
        return new Run(runId,runDate,runStatus,runWinner);
    }


    public List<Object> getFieldsToSave(Run run) {
        List<Object> objectsToSave = new ArrayList<>();
        objectsToSave.add(run.getRunDate());
        objectsToSave.add(run.getRunStatus().toString());
        objectsToSave.add(run.getRunWinner());
        //objectsToSave.add(run.getRunParticipants());
        return objectsToSave;
    }
}
