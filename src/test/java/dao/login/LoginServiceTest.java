package dao.login;


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
import ru.dbd.configuraions.PersistenceConf;
import ru.dbd.dao.user.UserDao;
import ru.dbd.dao.user.UserDaoBasic;
import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;
import ru.dbd.services.login.LoginService;
import ru.dbd.services.login.LoginServiceBasic;
import ru.dbd.services.user.UserService;
import ru.dbd.services.user.UserServiceBasic;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by vorh on 4/18/17.
 */

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Rollback
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    public static class ContextConfiguration extends PersistenceConf {
        @Override
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:test/user.sql")
                    .build();
        }

        @Bean
        public LoginService loginService(){
            return new LoginServiceBasic();
        }
        @Bean
        public UserService userService(){
            return new UserServiceBasic();
        }
        @Bean
        public UserDao userDao(){
            return new UserDaoBasic();
        }
    }


    @Test
    public void validate(){
        User user = new User();
        user.setLogin("TEST");
        user.setPassword("PAS");

        userService.saveUser(user);

        StatusLogin validate = loginService.validate(user);
        assertEquals(StatusLogin.SUCCESS,validate);

        user.setLogin("TEST2");
        validate=loginService.validate(user);
        assertEquals(StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT,validate);

        user.setPassword("PAS1");
        validate=loginService.validate(user);
        assertEquals(StatusLogin.LOGIN_OR_PASSWORD_NOT_CORRECT,validate);
    }


}
