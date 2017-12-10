package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.AnswerDAO;
import ru.innopolis.db.daos.AnswerDAOImpl;
import ru.innopolis.db.daos.QuestionDAO;
import ru.innopolis.db.daos.QuestionDAOImpl;
import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Category;
import ru.innopolis.pojo.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);

    @Override
    public List<Question> showQuestions(Category category) throws Exception {
        if (category==null) throw new Exception();
        QuestionDAO questionDAO = new QuestionDAOImpl();
        AnswerDAO answerDAO = new AnswerDAOImpl();
        List<Question> questionList = questionDAO.getByCategory(category);
        return questionList;
    }
}
