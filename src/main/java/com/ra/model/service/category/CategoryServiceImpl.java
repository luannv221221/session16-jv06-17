package com.ra.model.service.category;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean create(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    // Nếu rỗng thì trả vè fasle // có rồi trả về true
    public boolean checkNameExist(String name) {
        List<Category> categories = categoryDAO.findByName(name);
        // isEmpty() nếu rỗng trả về  true khác rỗng trar ve false
        return !categories.isEmpty();
    }
}
