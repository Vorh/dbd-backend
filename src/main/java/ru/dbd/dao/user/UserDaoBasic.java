package ru.dbd.dao.user;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.dbd.dao.AbstractDao;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/6/17.
 */

@Repository
public class UserDaoBasic extends AbstractDao implements UserDao{


    public void removeUser(User user) {
        getSession().delete(user);
    }

    public void saveUser(User user) {
        getSession().persist(user);
    }

    public User getUserByLogin(String login) {
        Query query = getSession().createQuery("FROM user WHERE login = :login ");
        query.setParameter("login",login);
        return (User) query.list().get(0);
    }
}
