package ru.innopolis.db.daos;

import ru.innopolis.pojo.Test;

public interface TestDAO {
    Boolean createTest(Test test) throws TestDAOImpl.TestDAOException;


}
