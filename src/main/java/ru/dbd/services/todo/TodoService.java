package ru.dbd.services.todo;

import ru.dbd.models.todo.SimpleTodo;
import ru.dbd.models.todo.Todo;

import java.util.List;

/**
 * Created by vorh on 4/3/17.
 */
public interface TodoService {

    List<SimpleTodo> getSimpleTodo();

    void saveTodo(Todo todo);

    void removeTodo(Todo todo);

}
