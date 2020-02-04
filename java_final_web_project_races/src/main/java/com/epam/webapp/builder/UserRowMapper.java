package com.epam.webapp.builder;

import com.epam.webapp.entity.User;
import com.epam.webapp.entity.UserStatus;
import com.epam.webapp.entity.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(User.ID);
        String login = resultSet.getString(User.LOGIN);
        String password = resultSet.getString(User.PASSWORD);
        String strStatus = resultSet.getString(User.STATUS);
        UserStatus status = UserStatus.valueOf(strStatus);
        String strType = resultSet.getString(User.TYPE);
        UserType type = UserType.valueOf(strType);
        double moneyBalance = resultSet.getDouble(User.MONEY_BALANCE);
        return new User(id, login, password,status,type,moneyBalance);
    }

    public List<Object> getFieldsToSave(User user) {
        List<Object> objectsToSave = new ArrayList<>();
        objectsToSave.add(user.getUserLogin());
        objectsToSave.add(user.getUserPassword());
        objectsToSave.add(user.getUserStatus().toString());
        objectsToSave.add(user.getUserType().toString());
        objectsToSave.add(user.getMoneyBalance());
        return objectsToSave;
    }
}
