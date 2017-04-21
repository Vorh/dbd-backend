package ru.dbd.services.security.storePrincipal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.dbd.models.user.User;
import ru.dbd.services.security.UserPrincipal;

/**
 * Created by vorh on 4/21/17.
 */

@Service
@Profile("dev")
public class StorePrincipalDev implements StorePrincipal{
    @Override
    public UserPrincipal user() {
        User user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setPassword("password");
        user.setEmail("sorcerer12@list.ru");
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
