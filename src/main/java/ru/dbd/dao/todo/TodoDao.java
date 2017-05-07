package ru.dbd.dao.todo;

import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
public interface TodoDao {


    List<Todo> getListTodo(int userID);

    void saveTodo(Todo todo);

    void removeTodo(Todo todo);

    Todo getTodoById(int id);

    void updateTodo(Todo todo);
}
