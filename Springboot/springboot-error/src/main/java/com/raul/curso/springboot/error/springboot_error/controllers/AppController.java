package com.raul.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.raul.curso.springboot.error.springboot_error.models.domain.User;
import com.raul.curso.springboot.error.springboot_error.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;
    @GetMapping
    public String index(){

        int value = Integer.parseInt("10x");

        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name="id") Long id) {
        return service
        .findById(id)
        .orElseThrow(()->new UserNotFoundException("Error el usuario no existe"));
    }
    
}
