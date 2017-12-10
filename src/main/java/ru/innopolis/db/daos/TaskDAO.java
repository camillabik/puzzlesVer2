package ru.innopolis.db.daos;

import ru.innopolis.pojo.Task;

public interface TaskDAO {
    Boolean createTask(Task task) throws TaskDAOImpl.TaskDAOException;
}
