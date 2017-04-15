package ru.dbd.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dbd.dao.user.UserDao;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/14/17.
 */

@Service
public class UserDetailServiceBasic implements UserDetailsService{


    @Autowired
    private UserDao userDao;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }



    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
