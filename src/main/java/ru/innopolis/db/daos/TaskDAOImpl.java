package ru.innopolis.db.daos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.innopolis.db.ConnectionManager;
import ru.innopolis.db.IConnectionManager;
import ru.innopolis.pojo.Task;
import ru.innopolis.pojo.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAOImpl implements TaskDAO {
    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(User.class);
    public static class TaskDAOException extends Exception {
    }

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Override
    public Boolean createTask(Task task) throws TaskDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("INSERT INTO tasks (user_id, question, user_answer, is_right) VALUES(?,?,?,?)");
            statement.setInt(1, task.getUser().getId());
            statement.setInt(2, task.getQuestion().getId());
            statement.setInt(3, task.getAnswer().getId());
            statement.setBoolean(4, task.isRight());
            statement.executeUpdate();


            if (statement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new TaskDAOException();
        }
        return false;
    }

}
