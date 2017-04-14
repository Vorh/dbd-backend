package ru.dbd.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dbd.dao.user.UserDao;
import ru.dbd.models.user.User;

import java.util.ArrayList;
import java.util.List;

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
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return createUser(user,authorities);
    }

    private org.springframework.security.core.userdetails.User createUser(User user, List<GrantedAuthority> list){
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),list);
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
