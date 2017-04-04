package ru.dbd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dbd.configuraions.AppConf;
import ru.dbd.dao.todo.TodoDaoBasic;
import ru.dbd.models.todo.SimpleTodo;

/**
 * Created by vorh on 4/3/17.
 */
public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConf.class);


        TodoDaoBasic bean = applicationContext.getBean(TodoDaoBasic.class);
        System.out.println("CREATE BEAN");
        SimpleTodo simpleTodo =new SimpleTodo();
        simpleTodo.setBody("TEST BODY");
        simpleTodo.setCaption("TEST CAPTION");
        bean.saveTodo(simpleTodo);

        System.out.println("INSERT TODO");
    }
}
