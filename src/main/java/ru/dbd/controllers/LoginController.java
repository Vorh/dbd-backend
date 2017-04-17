package ru.dbd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vorh on 4/17/17.
 */

@Controller
public class LoginController {


    @RequestMapping(value = "/verification",method = RequestMethod.GET)
    public String login(@RequestParam("username") String username ,
                        @RequestParam("password") String password){

        System.out.println(username);
        System.out.println(password);
        return "TEST";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        return "sign.html";
    }
}
