package ru.dbd.dao.user;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.dbd.dao.AbstractDao;
import ru.dbd.models.user.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vorh on 4/6/17.
 */

@Repository
@Transactional
public class UserDaoBasic extends AbstractDao implements UserDao{


    public void removeUser(User user) {
        getSession().delete(user);
    }

    public void saveUser(User user) {
        getSession().persist(user);

    }

    public User getUserByLogin(String login) {
        Query query = getSession().createQuery("FROM User WHERE login = :login ");
        query.setParameter("login",login);
        List list = query.list();
        if (list.size() ==0){
            return null;
        }else {
            return (User) query.list().get(0);
        }
    }

    @Override
    public User getUserById(int id) {
        Query query = getSession().createQuery("FROM User WHERE id = :id");
        query.setParameter("id",id);
        return (User) query.uniqueResult();
    }
}
