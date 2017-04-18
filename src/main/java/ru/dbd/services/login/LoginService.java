package ru.dbd.services.login;

import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/18/17.
 */
public interface LoginService {

    StatusLogin validate(User user);

}
