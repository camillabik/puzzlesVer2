package ru.innopolis.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.service.CategoriesService;
import ru.innopolis.service.RegistrationUserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class CategoriesController {
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);

    CategoriesService categoriesService;//inject by setter

    @Autowired
    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }


    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    protected String doPost(Model model, HttpSession session) {
        try {
            if (session.getAttribute("user")==null)return "index";
            model.addAttribute("categoryList", categoriesService.showCategories());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "test";
    }
}
