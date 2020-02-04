package com.epam.webapp.builder;

import com.epam.webapp.entity.Bet;
import com.epam.webapp.entity.BetStatus;
import com.epam.webapp.entity.BetType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BetRowMapper implements RowMapper<Bet>{
    @Override
    public Bet map(ResultSet resultSet) throws SQLException {
        String userLogin = resultSet.getString(Bet.USER_LOGIN);
        String strBetType = resultSet.getString(Bet.BET_TYPE);
        BetType betType = BetType.valueOf(strBetType);
        double betSize = resultSet.getDouble(Bet.BET_SIZE);
        double coefficient = resultSet.getDouble(Bet.COEFFICIENT);
        double winning = resultSet.getDouble(Bet.WINNING);
        String strBetStatus = resultSet.getString(Bet.BET_STATUS);
        BetStatus betStatus = BetStatus.valueOf(strBetStatus);
        return new Bet(userLogin,betType,betSize,coefficient,winning,betStatus);
    }

    @Override
    public List<Object> getFieldsToSave(Bet item) {
        return null;
    }
}
