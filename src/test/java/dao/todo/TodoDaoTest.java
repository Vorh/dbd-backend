package dao.todo;

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
import ru.dbd.dao.todo.TodoDao;
import ru.dbd.dao.todo.TodoDaoBasic;
import ru.dbd.models.todo.Todo;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vorh on 4/11/17.
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Rollback
public class TodoDaoTest {

    @Autowired
    private TodoDao todoDao;

    public static final int USER_ID = 1;

    static class ContextConfiguration extends PersistenceConf {
        @Override
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:test/user.sql")
                    .addScript("classpath:test/todo.sql")
                    .build();
        }

        @Bean
        public TodoDao getTodoDao() {
            return new TodoDaoBasic();
        }
    }

    public Todo createTodo(){
        Todo todo = new Todo();
        todo.setBody("TEST");
        todo.setCaption("CAPTION");
        todo.setUserID(USER_ID);
        return todo;
    }


    @Test
    public void saveTodo() {
        Todo todo = createTodo();

        todoDao.saveTodo(todo);

        List<Todo> listTodo = todoDao.getListTodo(1);

        assertEquals(listTodo.size(),1);

        Todo resultTodo = listTodo.get(0);

        assertEquals(todo.getBody(),resultTodo.getBody());
        assertEquals(todo.getCaption(),resultTodo.getCaption());
        assertEquals(USER_ID,resultTodo.getUserID());

    }


    @Test
    public void removeTodo() throws Exception {
        Todo todo = createTodo();


        todoDao.saveTodo(todo);

        List<Todo> getListTodo = todoDao.getListTodo(USER_ID);

        todoDao.removeTodo(getListTodo.get(0));

        List<Todo> listTodo = todoDao.getListTodo(USER_ID);

        assertEquals(0,listTodo.size());
    }

    @Test
    public void getListTodo(){
        Todo todo0 = createTodo();
        Todo todo1 = createTodo();

        todo0.setCaption("TEST0");
        todo1.setCaption("TEST1");

        todoDao.saveTodo(todo0);
        todoDao.saveTodo(todo1);

        List<Todo> listTodo = todoDao.getListTodo(USER_ID);

        Todo test0 = listTodo.get(0);
        Todo test1 = listTodo.get(1);

        if (!test0.getCaption().equals(todo0.getCaption())){
            assertEquals(test0.getCaption(),todo1.getCaption());
        }

        if (!test1.getCaption().equals(todo1.getCaption())){
            assertEquals(test1.getCaption(),todo0.getCaption());
        }
    }
}
