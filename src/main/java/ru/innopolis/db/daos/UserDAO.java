package ru.innopolis.db.daos;

import ru.innopolis.pojo.User;

import java.util.List;

public interface UserDAO{
    User getUserByLoginAndPassword(String login, String password) throws UserDAOImpl.UserDAOException;
    Boolean createUser(User user) throws UserDAOImpl.UserDAOException;
    List<User> getAll() throws UserDAOImpl.UserDAOException;
}
