package ru.innopolis.db.daos;

import ru.innopolis.pojo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    List<Category> getAll() throws CategoryDAOImpl.CategoryDAOException;
    Category getById(int id) throws SQLException, CategoryDAOImpl.CategoryDAOException;
}
