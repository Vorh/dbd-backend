package ru.dbd.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;
import ru.dbd.services.user.UserService;

/**
 * Created by vorh on 4/18/17.
 */
@Service
public class LoginServiceBasic implements LoginService{

    @Autowired
    private UserService userService;

    @Override
    public StatusLogin validate(User user) {
        User userByLogin = userService.getUserByLogin(user.getLogin());

        if (userByLogin==null){
            return StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT;
        }
        if (!userByLogin.getLogin().equals(user.getLogin())){
            return StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT;
        }
        if (!userByLogin.getPassword().equals(user.getPassword())){
            return StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT;
        }

        return StatusLogin.SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
