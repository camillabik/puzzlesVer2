package ru.innopolis.db.daos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Repository;
import ru.innopolis.db.ConnectionManager;
import ru.innopolis.db.IConnectionManager;
import ru.innopolis.pojo.Answer;
import ru.innopolis.pojo.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswerDAOImpl implements AnswerDAO {


    public static class AnswerDAOException extends Exception {
    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(Answer.class);

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Override
    public List<Answer> getByQuestion(Question question) throws AnswerDAOException {

        ArrayList<Answer> answersByQuestion = new ArrayList<>();
        Answer answer = null;
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT\n" +
                            "answers.*,\n" +
                            "questions.id AS question_id\n" +
                            "FROM answers\n" +
                            "JOIN questions\n" +
                            "ON answers.question = questions.id\n" +
                            "WHERE answers.question = ?");
            statement.setInt(1, question.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Question question1 = new Question(resultSet.getInt("question_id"));

                answer = new Answer(resultSet.getInt("id"), question1, resultSet.getString("text"), resultSet.getBoolean("isRight"));
                answersByQuestion.add(answer);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new  AnswerDAOException();
        }
        return answersByQuestion;
}

    @Override
    public Answer getById() throws AnswerDAOException {
        return null;
    }
}

