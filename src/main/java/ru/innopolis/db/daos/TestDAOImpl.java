package ru.innopolis.db.daos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.innopolis.db.ConnectionManager;
import ru.innopolis.db.IConnectionManager;
import ru.innopolis.pojo.Test;
import ru.innopolis.pojo.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDAOImpl implements TestDAO {
    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(User.class);

    public static class TestDAOException extends Exception {
    }

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Override
    public Boolean createTest(Test test) throws TestDAOException{
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("INSERT INTO game_results_by_user (name, login, password) VALUES(?,?,?)");
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getLogin());
//            statement.setString(3, user.getPassword());
            //  statement.setBoolean(4, user.isAdmin());
            statement.executeUpdate();


            if (statement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new TestDAOException();
        }
        return false;
    }

}
