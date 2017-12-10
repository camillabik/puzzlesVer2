package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.UserDAO;
import ru.innopolis.db.daos.UserDAOImpl;
import ru.innopolis.pojo.User;


@Service
public class RegistrationUserServiceImpl implements RegistrationUserService{

    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);
 //   @Autowired
    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registrationUser(User user) throws Exception {
        if (user.getLogin()==null||user.getPassword()==null||user.getName()==null) throw new Exception();
        userDAO.createUser(user);
    }

}
