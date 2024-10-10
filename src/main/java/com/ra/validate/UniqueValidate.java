package com.ra.validate;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueValidate implements ConstraintValidator<UniqueCategory,String> {
    private final CategoryDAO categoryDAO;
    @Autowired
    public UniqueValidate(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Allow null or empty values
        }
        return categoryDAO.findByName(value).isEmpty();
    }
}
