package ru.dbd.controllers.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbd.models.todo.Todo;

/**
 * Created by vorh on 4/4/17.
 */

@RestController
public class TodoController {


    @RequestMapping
    public Todo getSimpleTodo(){
        return  new Todo();
    }
}
