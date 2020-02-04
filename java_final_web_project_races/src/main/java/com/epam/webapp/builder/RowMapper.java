package com.epam.webapp.builder;

import com.epam.webapp.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;
    List<Object> getFieldsToSave(T item);
    static RowMapper<? extends Identifiable>  create(String table) {
        switch (table) {
            case User.TABLE :
                return new UserRowMapper();
            case Bet.TABLE :
                return new BetRowMapper();
            case Run.TABLE :
                return new RunRowMapper();
            case RunParticipant.TABLE :
                return new RunParticipantRowMapper();
            case RaceParticipant.TABLE :
                return new RaceParticipantRowMapper();
            default:
                throw new IllegalArgumentException("unknown table" + table);

        }


    }

}
