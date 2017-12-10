package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.AnswerDAO;
import ru.innopolis.db.daos.AnswerDAOImpl;
import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Question;
import ru.innopolis.pojo.User;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private static final Logger logger = Logger.getLogger(User.class);

    @Override
    public List<Answer> showAnswersByQuestion(Question question) {
        AnswerDAO answerDAO = new AnswerDAOImpl();
        List<Answer> answersByQuestion = null;
        try {
            answersByQuestion = answerDAO.getByQuestion(question);
        } catch (AnswerDAOImpl.AnswerDAOException e) {
            logger.error(e.getMessage());
        }
        return answersByQuestion;
    }
}
