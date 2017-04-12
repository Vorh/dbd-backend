package ru.dbd.controllers.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vorh on 4/4/17.
 */

@Controller
public class TodoController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getTodoList(){
        System.out.println("TEST");
        return  null;
    }
}
