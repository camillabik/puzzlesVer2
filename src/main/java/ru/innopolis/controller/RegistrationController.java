package ru.innopolis.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.pojo.User;
import ru.innopolis.service.RegistrationUserService;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {
    private static final Logger logger = Logger.getLogger(User.class);
    RegistrationUserService registrationUserService;
    @Autowired
    public void setRegistrationUserService(RegistrationUserService registrationUserService) {
        this.registrationUserService = registrationUserService;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    protected String doPost(@RequestParam String login, @RequestParam String password,
                            @RequestParam String name, HttpSession session) {
        User user = new User(name, login, password);
        try {
            registrationUserService.registrationUser(user);
            session.setAttribute("authorized", true);
            session.setAttribute("user", user);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "hello_authorization";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    protected String doGet() {
        return "registration";
    }
}


