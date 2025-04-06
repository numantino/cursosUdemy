package com.raul.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.raul.curso.springboot.app.springboot_crud.services.ProdcutService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistsDbImp implements ConstraintValidator<IsExistsDb, String>{

    @Autowired
    private ProdcutService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !service.existsBySku(value);
    }

}
