package ru.innopolis.db.daos;

import ru.innopolis.pojo.Category;
import ru.innopolis.pojo.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getByCategory(Category category) throws QuestionDAOImpl.QuestionDAOException;

    Question getById(int id) throws QuestionDAOImpl.QuestionDAOException;


}
