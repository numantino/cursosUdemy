package com.raul.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.app.aop.springboot_aop.services.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greeting;

    @GetMapping("/greeting")
    public ResponseEntity<?> grreting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting.sayHello("Raul", "Hola que tal")));
    }
    @GetMapping("/greeting-error")
    public ResponseEntity<?> grretingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting.sayHelloError("Raul", "Hola que tal")));
    }

}
