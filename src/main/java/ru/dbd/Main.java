package ru.dbd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dbd.configuraions.AppConf;
import ru.dbd.dao.user.UserDao;
import ru.dbd.models.todo.Todo;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/3/17.
 */
public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConf.class);


        UserDao bean = applicationContext.getBean(UserDao.class);
        System.out.println("CREATE BEAN");
        Todo todo =new Todo();
        todo.setBody("TEST BODY");
        todo.setCaption("TEST CAPTION");

        User user = new User();
        user.setLogin("LOGIN");
        user.setPassword("USER");
        user.setEmail("TEST");

        bean.getUserByLogin("Vorh");

        System.out.println("INSERT TODO");
    }
}
