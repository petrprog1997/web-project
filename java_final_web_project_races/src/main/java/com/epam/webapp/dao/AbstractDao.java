package com.epam.webapp.dao;

import com.epam.webapp.builder.RowMapper;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {

    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }


    public List<T> executeQuery(String query, RowMapper<T> mapper, Object ... params) {
        try(PreparedStatement preparedStatement = createStatement(query,params);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private PreparedStatement createStatement(String query, Object ... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for(int i = 1; i <= params.length; i++) {
            preparedStatement.setObject(i,params[i-1]);
        }
        return preparedStatement;
    }

    @Override
    public List<T> getAll() {
        String tableName = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(tableName);
        return executeQuery("select * from " + tableName,mapper);
    }

    protected Optional<T> executeForSingleResult(String query,RowMapper<T> mapper, Object ... params) {
        List<T> items = executeQuery(query,mapper,params);
        if(items.size() == 1) {
            return Optional.of(items.get(0));
        } else if(items.size() > 1) {
            throw new IllegalArgumentException("More than one record found");
        } else {
            return Optional.empty();
        }
    }

    public void executeUpdate(String query,Object ... params) {
        try(PreparedStatement preparedStatement = createStatement(query,params)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void executeUpdateForSave( T item, String query) throws DaoException {
        String table = getTableName();
        RowMapper<T> rowMapper = (RowMapper<T>) RowMapper.create(table);
        List<Object> objectsToSave = rowMapper.getFieldsToSave(item);
        try (PreparedStatement preparedStatement = createStatement(query, objectsToSave.toArray())){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    public abstract String getTableName();
}
