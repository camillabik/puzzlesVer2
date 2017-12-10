package ru.innopolis.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.pojo.Category;
import ru.innopolis.pojo.Question;
import ru.innopolis.pojo.User;
import ru.innopolis.service.AnswerService;
import ru.innopolis.service.AuthorizationUserService;
import ru.innopolis.service.QuestionService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TestController {
    private static final Logger logger = Logger.getLogger(User.class);
    //    @Autowired
//    AuthorizationUserService authorizationUserService;
    QuestionService questionService;
    AnswerService answerService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String doGet(Category category, Model model, HttpSession session) {
        try {
            List<Question> questionList = questionService.showQuestions(category);
            model.addAttribute("questionList", questionList);
            for (Question q : questionList) {
                model.addAttribute("answersByQuestion", answerService.showAnswersByQuestion(q));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return "test";
    }
}
