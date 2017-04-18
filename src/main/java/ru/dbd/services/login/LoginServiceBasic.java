package ru.dbd.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.dao.user.UserDao;
import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/18/17.
 */
@Service
public class LoginServiceBasic implements LoginService{

    @Autowired
    private UserDao userDao;

    @Override
    public StatusLogin validate(User user) {
        User userByLogin = userDao.getUserByLogin(user.getLogin());

        if (!userByLogin.getLogin().equals(user.getLogin())){
            return StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT;
        }
        if (!userByLogin.getPassword().equals(user.getPassword())){
            return StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT;
        }

        return StatusLogin.SUCCESS;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
