package ru.innopolis.service;

import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Question;

import java.util.List;

public interface AnswerService {
    List<Answer> showAnswersByQuestion(Question question);
}
