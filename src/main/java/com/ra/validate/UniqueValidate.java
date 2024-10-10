package com.ra.validate;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueValidate implements ConstraintValidator<UniqueCategory,String> {
    private final CategoryService categoryService;
    @Autowired
    public UniqueValidate(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !categoryService.checkNameExist(value);
    }
}
