package com.epam.webapp.dao;

import com.epam.webapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {

        Optional<User> getByLoginAndPassword(String login,String password);

        List<User> getByMoneyBalance(String minMoneyBalance, String maxMoneyBalance);

        void changeUserStatus(long UserId);

}
