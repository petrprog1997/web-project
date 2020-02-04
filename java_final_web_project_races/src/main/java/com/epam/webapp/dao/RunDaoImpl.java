package com.epam.webapp.dao;

import com.epam.webapp.builder.RunRowMapper;
import com.epam.webapp.entity.Run;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class RunDaoImpl extends AbstractDao<Run> implements RunDao {

    private final String FIND_BY_ID = "select * from runs where " + Run.ID + "= ?";
    private final String FIND_BY_RUN_DATE = "select * from runs where " + Run.RUN_DATE + "= ?";
    private final String REMOVE_BY_ID = "delete from runs where " + Run.ID + "= ?";
    private final String SAVE_RUN = "insert into runs(run_date,run_status,run_winner) " +
            "VALUES(?, ?, ?);";

    public RunDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Run.TABLE;
    }

    @Override
    public Optional<Run> findById(Long id) {
        return executeForSingleResult(FIND_BY_ID,new RunRowMapper(),id);
    }

    @Override
    public List<Run> getByRunDate(Date date) {
        return executeQuery(FIND_BY_RUN_DATE,new RunRowMapper(),date);
    }

    @Override
    public void removeById(Long id) {
        executeUpdate(REMOVE_BY_ID,id);
    }

    @Override
    public void save(Run entity) {
        executeUpdateForSave(entity, SAVE_RUN);
    }
}
