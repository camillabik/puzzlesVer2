package ru.innopolis.db.daos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Repository;
import ru.innopolis.db.ConnectionManager;
import ru.innopolis.db.IConnectionManager;
import ru.innopolis.pojo.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(Category.class);

    public static class CategoryDAOException extends Exception {
    }

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");
    }

    @Override
    public List<Category> getAll() throws CategoryDAOException {
        List<Category> categories = new  ArrayList<>();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");

            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new CategoryDAOException();
        }
        return categories;
    }


    @Override
    public Category getById(int id) throws CategoryDAOException{
        Category category = null;

        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT * FROM categories WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                category = new Category(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new CategoryDAOException();
        }
        return category;
    }
}
