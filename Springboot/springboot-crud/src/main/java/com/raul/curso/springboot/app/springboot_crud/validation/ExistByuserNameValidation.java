package com.raul.curso.springboot.app.springboot_crud.validation;

import org.springframework.stereotype.Component;

import com.raul.curso.springboot.app.springboot_crud.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByuserNameValidation implements ConstraintValidator<ExistByuserName, String>{

    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existexistsByUserName(value);
    }

}
