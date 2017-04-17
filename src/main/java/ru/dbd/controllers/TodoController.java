package ru.dbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.dbd.models.todo.Todo;
import ru.dbd.services.todo.TodoService;

import java.util.List;

/**
 * Created by vorh on 4/4/17.
 */

@Controller
public class TodoController {

    private static final String PATH = "/todo";

    @Autowired
    private TodoService todoService;


    @RequestMapping(value = PATH + "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @RequestMapping(value = PATH + "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Todo getTodo(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }

    @RequestMapping(value = PATH + "/remove/{id}", method = RequestMethod.GET)
    public void removeTodo(@PathVariable("id") int id) {
        Todo todo = new Todo();
        todo.setId(id);
        todoService.removeTodo(todo);
    }

    @RequestMapping(value = PATH + "/add", method = RequestMethod.GET)
    public void addTodo(@RequestBody Todo todo) {
        todoService.saveTodo(todo);
    }


    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
