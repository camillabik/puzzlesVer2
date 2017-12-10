package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.TaskDAO;
import ru.innopolis.db.daos.TaskDAOImpl;
import ru.innopolis.pojo.Task;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);
    private static TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    public void taskUser(Task task) throws Exception {
        if (task.getUser()==null||task.getAnswer()==null||task.getQuestion()==null) throw new Exception();
        taskDAO.createTask(task);
    }
}
