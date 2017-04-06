package ru.dbd.dao.user;

import ru.dbd.dao.AbstractDao;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/6/17.
 */
public class UserDaoBasic extends AbstractDao implements UserDao{


    public void removeUser(User user) {
        getSession().delete(user);
    }

    public void saveUser(User user) {
        getSession().persist(user);
    }

    public User getUserByLogin(String login) {
        return null;
    }
}
