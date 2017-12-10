package ru.innopolis.db.daos;


import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getByQuestion(Question question) throws AnswerDAOImpl.AnswerDAOException;
    Answer getById() throws AnswerDAOImpl.AnswerDAOException;

}

