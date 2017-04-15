package ru.dbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dbd.models.user.User;
import ru.dbd.services.registration.RegistrationService;

/**
 * Created by vorh on 4/15/17.
 */

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(@RequestBody User user){

//        StatusRegistration register = registrationService.register(user);
//        switch (register){
//            case OK:
//                return (HttpEntity) ResponseEntity.status(HttpStatus.OK);
//            case EXIST_LOGIN:
//                return (HttpEntity) ResponseEntity.status(422);
//        }
        return "test";
    }

}
