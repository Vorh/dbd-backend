package ru.dbd.controllers.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dbd.models.todo.Todo;
import ru.dbd.services.todo.TodoService;

import java.util.List;

/**
 * Created by vorh on 4/4/17.
 */

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;


    @RequestMapping(value = "/todoList",method = RequestMethod.GET)
    public @ResponseBody List<Todo> getTodoList(){
        return todoService.getTodoList();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public @ResponseBody Todo getTodo(@PathVariable("id") int id){
        return todoService.getTodoById(id);
    }
}
