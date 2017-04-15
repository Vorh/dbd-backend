package ru.dbd.services.user;

import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/15/17.
 */
public interface UserService {


    void removeUser(User user);

    void saveUser(User user);

    User getUserByLogin(String login);

    User getUserById(int id);
}
