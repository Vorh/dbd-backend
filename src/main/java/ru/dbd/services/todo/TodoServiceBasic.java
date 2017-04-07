package ru.dbd.services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dbd.dao.todo.TodoDao;
import ru.dbd.models.todo.SimpleTodo;
import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
public class TodoServiceBasic implements TodoService{

    @Autowired
    private TodoDao todoDao;

    public TodoServiceBasic(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<SimpleTodo> getSimpleTodo() {
        return null;
    }

    public void saveTodo(Todo todo) {
        todoDao.saveTodo(todo);
    }

    public void removeTodo(Todo todo) {
        todoDao.removeTodo(todo);
    }
}