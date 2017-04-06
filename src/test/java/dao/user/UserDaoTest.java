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

    @Test
    public void addUser(){
        String login = "LOGIN";
        User user = new User();
        user.setLogin(login);
        user.setPassword("PASSWORD");
        user.setEmail("email");

        userDao.saveUser(user);

        User userByLogin = userDao.getUserByLogin(login);

        assertEquals(userByLogin.getLogin(),login);
    }

}
