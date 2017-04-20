package ru.dbd.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dbd.services.security.UserPrincipal;

/**
 * Created by vorh on 4/20/17.
 */
@Controller
public class DashboardController {


    @RequestMapping(value = "/dbd",method = RequestMethod.GET)
    public String getDbd(){
        return "/dist/index.html";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication();

        System.out.println(user == null);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
    }
}
