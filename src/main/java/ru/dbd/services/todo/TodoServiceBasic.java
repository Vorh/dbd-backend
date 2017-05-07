package ru.dbd.services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.dao.todo.TodoDao;
import ru.dbd.models.todo.Todo;
import ru.dbd.services.security.UserPrincipal;
import ru.dbd.services.security.storePrincipal.StorePrincipal;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
@Service
public class TodoServiceBasic implements TodoService{

    private TodoDao todoDao;
    private UserPrincipal user;




    public List<Todo> getTodoList() {
        return todoDao.getListTodo(user.getId());
    }

    public void saveTodo(Todo todo) {
        todo.setUserID(user.getId());
        todoDao.saveTodo(todo);
    }

    public void removeTodo(Todo todo) {
        todoDao.removeTodo(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        return todoDao.getTodoById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todo.setUserID(user.getId());
        todoDao.updateTodo(todo);
    }


    @Autowired
    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Autowired
    public void setStorePrincipal(StorePrincipal storePrincipal) {
        user = storePrincipal.user();
    }
}
