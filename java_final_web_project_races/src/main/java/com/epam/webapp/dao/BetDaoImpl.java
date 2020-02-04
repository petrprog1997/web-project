package com.epam.webapp.dao;

import com.epam.webapp.builder.BetRowMapper;
import com.epam.webapp.entity.Bet;
import com.epam.webapp.entity.BetStatus;
import com.epam.webapp.entity.BetType;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class BetDaoImpl extends AbstractDao<Bet> implements BetDao {

    private final String FIND_BY_ID = "select * from bets where " + Bet.ID + "= ?";
    private final String FIND_BY_BET_TYPE = "select * from bets where " + Bet.BET_TYPE + "= ?";
    private final String FIND_BY_BET_STATUS = "select * from bets where " + Bet.BET_STATUS + "= ?";
    private final String FIND_BY_BET_COEFFICIENT = "select * from bets where " + Bet.COEFFICIENT + "= ?";
    private final String REMOVE_BY_ID = "delete from bets where " + Bet.ID + "= ?";

    public BetDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Bet.TABLE;
    }

    @Override
    public Optional<Bet> findById(Long id) {
        return executeForSingleResult(FIND_BY_ID, new BetRowMapper(), id);
    }

    @Override
    public List<Bet> getByBetType(BetType betType) {
        return executeQuery(FIND_BY_BET_TYPE, new BetRowMapper(), betType);
    }

    @Override
    public List<Bet> getByBetStatus(BetStatus betStatus) {
        return executeQuery(FIND_BY_BET_STATUS, new BetRowMapper(), betStatus);
    }

    @Override
    public List<Bet> getByCoefficient(double coefficient) {
        return executeQuery(FIND_BY_BET_COEFFICIENT, new BetRowMapper(), coefficient);
    }

    @Override
    public void removeById(Long id) {
        executeUpdate(REMOVE_BY_ID,id);
    }

    @Override
    public void save(Bet entity) {

    }
}
