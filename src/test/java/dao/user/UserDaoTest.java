package dao.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import ru.dbd.configuraions.PersistenceConf;
import ru.dbd.dao.user.UserDao;
import ru.dbd.dao.user.UserDaoBasic;
import ru.dbd.models.user.User;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vorh on 4/6/17.
 */

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Rollback
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    private static final String login = "LOGIN";


    static class ContextConfiguration extends PersistenceConf {


        @Override
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:test/create.sql")
//                .addScript()
                    .build();
        }

        @Bean
        public UserDao getUserDao(){
            return new UserDaoBasic();
        }
    }

    public User createUser(){
        User user = new User();
        user.setLogin(login);
        user.setPassword("PASSWORD");
        user.setEmail("email");
        return user;
    }

    @Test
    public void addUserAndSearchUserByLogin(){
        userDao.saveUser(createUser());
        User userByLogin = userDao.getUserByLogin(login);

        assertEquals(userByLogin.getLogin(), login);
    }


    @Test
    public void removeUser(){
        userDao.saveUser(createUser());
        User userByLogin = userDao.getUserByLogin(login);
        userDao.removeUser(userByLogin);
        userByLogin = userDao.getUserByLogin(login);

        assertNull(userByLogin);
    }

    @Test
    public void getUserById(){
        User userById = userDao.getUserById(1);
        assertEquals(userById.getLogin(),"BY_ID");
    }
}
