package ru.dbd.services.todo;

import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
public interface TodoService {

    List<Todo> getTodoList();

    void addTodo(Todo todo);

    void removeTodo(Todo todo);

    Todo getTodoById(int  id);

    void updateTodo(Todo todo);
}
