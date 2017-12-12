package ru.innopolis.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.User;
import ru.innopolis.service.AuthorizationUserService;
import ru.innopolis.service.AuthorizationUserServiceImpl;
import ru.innopolis.service.CategoriesService;
import ru.innopolis.service.CategoriesServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class AuthorizationController {
    private static final Logger logger = Logger.getLogger(Answer.class);

    private static CategoriesService categoriesService = new CategoriesServiceImpl();

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    protected String doPost(@RequestParam String login, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("Hello World");

        AuthorizationUserService authorizationUserService = new AuthorizationUserServiceImpl();
        try {
            User user = authorizationUserService.authorization(login, password);
            session.setAttribute("authorized", true);
            session.setAttribute("user", user);
            session.setAttribute("categoryList", categoriesService.showCategories());
        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("error", "err");
        }
        return "categories";
    }


    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    protected String doGet()  {
        return "authorization";
    }
}

