package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.UserDAO;
import ru.innopolis.db.daos.UserDAOImpl;
import ru.innopolis.pojo.User;
import ru.innopolis.utils.PasswordEncoder;

@Service
public class AuthorizationUserServiceImpl implements AuthorizationUserService {
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);

    @Override
    public User authorization(String login, String password) throws Exception {//spec concrete exception
        if (login==null||password==null) throw new Exception();
        UserDAO userDAO = new UserDAOImpl();

        User user = null;
        try {
            user = userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password));
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return user;

    }
}
