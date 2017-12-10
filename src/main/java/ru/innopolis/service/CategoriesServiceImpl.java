package ru.innopolis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.innopolis.db.daos.CategoryDAO;
import ru.innopolis.db.daos.CategoryDAOImpl;
import ru.innopolis.pojo.Category;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService{
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);

    @Override
    public List<Category> showCategories() {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        List<Category> categories = null;
        try {
            categories = categoryDAO.getAll();
        } catch (CategoryDAOImpl.CategoryDAOException e) {
            logger.error(e.getMessage());
        }
        return categories;//categories;
    }
}
