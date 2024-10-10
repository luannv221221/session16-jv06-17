package com.ra.validate;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileNotNullValidator implements ConstraintValidator<FileNotNull, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return value.getSize() != 0;
    }
}
