package ru.innopolis.db.daos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Repository;
import ru.innopolis.db.ConnectionManager;
import ru.innopolis.db.IConnectionManager;
import ru.innopolis.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(User.class);


    public static class UserDAOException extends Exception {
    }

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws UserDAOException {
        User user = null;
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT * FROM users WHERE login = ? AND  password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("name"),resultSet.getString("login"),
                        resultSet.getString("password"),  resultSet.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UserDAOException();
        }
        return user;
    }

    @Override
    public Boolean createUser(User user) throws UserDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("INSERT INTO users (name, login, password) VALUES(?,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
          //  statement.setBoolean(4, user.isAdmin());
            statement.executeUpdate();


            if (statement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UserDAOException();
        }
        return false;
    }

    @Override
    public List<User> getAll() throws UserDAOException {
        logger.debug("log for getAll (Users)");
        try {
            List<User> users = new ArrayList<>();
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User(
                         resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_admin"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UserDAOException();
        }
    }


}
