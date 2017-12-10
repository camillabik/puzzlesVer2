package ru.innopolis.service;

import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Category;
import ru.innopolis.pojo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<Question> showQuestions(Category category) throws Exception;
}
