package com.epam.webapp.service;

import com.epam.webapp.dao.*;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private DaoHelperFactory factory;

    public UserService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public Optional<User> login(String login,String password) throws ServiceException {
            try(DaoHelper helper = factory.create()) {
                UserDao userDao = helper.createUserDao();
                return userDao.getByLoginAndPassword(login,password);
            } catch (Exception e) {
                throw new ServiceException(e);
            }
    }

    public List<User> getAllUsers() throws Exception {
        try(DaoHelper helper = factory.create()){
            AbstractDao<User> userAbstractDao = (AbstractDao<User>) helper.createUserDao();
            return userAbstractDao.getAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void registration(User user) throws IOException, ServiceException {
        try(DaoHelper helper = factory.create()) {
            UserDao userDao = helper.createUserDao();
            userDao.save(user);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void changeUserStatus(long id) throws ServiceException {
        try(DaoHelper helper = factory.create()) {
            UserDao userDao = helper.createUserDao();
            userDao.changeUserStatus(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

}
