package ru.dbd.dao.todo;

import org.springframework.stereotype.Repository;
import ru.dbd.dao.AbstractDao;
import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */

@Repository
public class TodoDaoBasic extends AbstractDao implements TodoDao{

    public List<Todo> getListTodo(int userID) {
        return null;
    }

    public void saveTodo(Todo simpleTodo) {
        getSession().persist(simpleTodo);
    }

    public void removeTodo(Todo simpleTodo) {

    }
}
