package ru.dbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dbd.models.login.StatusLogin;
import ru.dbd.models.user.User;
import ru.dbd.services.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vorh on 4/17/17.
 */

@Controller
@Profile("prod")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private CsrfTokenRepository tokenRepository;

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpServletResponse response) {
        User user = new User();
        user.setPassword(password);
        user.setLogin(username);
        StatusLogin validate = loginService.validate(user);
        response.addHeader("TESt","TEST");

    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request,HttpServletResponse response) {

        return "sign.html";
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTokenRepository(CsrfTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}
