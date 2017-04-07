package ru.dbd.dao.user;

import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/6/17.
 */
public interface UserDao {

    void removeUser(User user);

    void saveUser(User user);

    User getUserByLogin(String login);

    User getUserById(int id);
}
