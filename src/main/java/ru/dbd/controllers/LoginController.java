package ru.dbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;
import ru.dbd.services.login.LoginService;

/**
 * Created by vorh on 4/17/17.
 */

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/verification",method = RequestMethod.GET)
    public @ResponseBody StatusLogin login(@RequestParam("username") String username ,
          @RequestParam("password") String password){
        User user = new User();
        user.setPassword(password);
        user.setLogin(username);
        StatusLogin validate = loginService.validate(user);
        System.out.println(validate.name());
        return validate;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        return "sign.html";
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
