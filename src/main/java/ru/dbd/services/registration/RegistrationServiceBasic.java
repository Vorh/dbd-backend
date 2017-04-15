package ru.dbd.services.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.models.registration.StatusRegistration;
import ru.dbd.models.user.User;
import ru.dbd.services.user.UserService;

/**
 * Created by vorh on 4/15/17.
 */
@Service
public class RegistrationServiceBasic implements RegistrationService{


    @Autowired
    private UserService userService;


    @Override
    public StatusRegistration register(User user) {
        User userByLogin = userService.getUserByLogin(user.getLogin());

        if (userByLogin != null){
            return StatusRegistration.EXIST_LOGIN;
        }
        userService.saveUser(user);
        return StatusRegistration.OK;
    }

    @Override
    public void recoveryAccess() {
        // STUB
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
