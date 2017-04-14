package ru.dbd.services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbd.dao.todo.TodoDao;
import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
@Service
public class TodoServiceBasic implements TodoService{

    @Autowired
    private TodoDao todoDao;

    public TodoServiceBasic() {
    }

    public TodoServiceBasic(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<Todo> getTodoList() {

        //TODO REPLACE
        return todoDao.getListTodo(1);
    }

    public void saveTodo(Todo todo) {
        todoDao.saveTodo(todo);
    }

    public void removeTodo(Todo todo) {
        todoDao.removeTodo(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        return todoDao.getTodoById(id);
    }
}
