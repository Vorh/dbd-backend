package ru.dbd.controllers.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbd.models.todo.SimpleTodo;

/**
 * Created by vorh on 4/4/17.
 */

@RestController
public class TodoController {


    @RequestMapping
    public SimpleTodo getSimpleTodo(){
        return  new SimpleTodo();
    }
}
