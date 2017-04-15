package ru.dbd.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.dao.user.UserDao;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/15/17.
 */
@Service
public class UserServiceBasic implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Override
    public void saveUser(User user) {
            userDao.saveUser(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
