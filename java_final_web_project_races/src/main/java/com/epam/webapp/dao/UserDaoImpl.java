package com.epam.webapp.dao;

import com.epam.webapp.builder.UserRowMapper;
import com.epam.webapp.entity.User;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private final String FIND_BY_ID = "select * from users where " + User.ID + " = ?;";
    private final String FIND_BY_LOGIN_AND_PASSWORD = "select * from users where " + User.LOGIN + "= ? and " +
            User.PASSWORD + " = ?";
    private final String FIND_BY_MONEY_BALANCE = "select * from users where " + User.MONEY_BALANCE + "> ? and < ?";
    private final String REMOVE_BY_ID = "delete from users where " + User.ID + "= ?";
    private final String SAVE_USER = "insert into users(user_login, user_password, user_status, user_type, " +
            "user_money_balance) " + "VALUES(?, ?, ?, ?, ?)";
    private final String CHANGE_USER_STATUS = "update " + User.TABLE + " set " + User.STATUS + " CASE WHEN " + User.STATUS +
            "= ACTIVE THEN BLOCKED ELSE ACTIVE END where " + User.ID +"=?;";

    public UserDaoImpl(Connection connection) {super(connection);}

    @Override
    public String getTableName() {
        return User.TABLE;
    }

    @Override
    public Optional<User> getByLoginAndPassword(String login, String password) {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public List<User> getByMoneyBalance(String minMoneyBalance, String maxMoneyBalance) {
        return executeQuery(FIND_BY_MONEY_BALANCE, new UserRowMapper(), minMoneyBalance, maxMoneyBalance);
    }


    @Override
    public Optional<User> findById(Long id) {
        return executeForSingleResult(FIND_BY_ID, new UserRowMapper(), id);
    }

    @Override
    public void removeById(Long id) {
         executeUpdate(REMOVE_BY_ID,id);
    }

    @Override
    public void save(User entity) {
        executeUpdateForSave(entity,SAVE_USER);
    }

    @Override
    public void changeUserStatus(long UserId) {
        executeUpdate(CHANGE_USER_STATUS, UserId);
    }
}
