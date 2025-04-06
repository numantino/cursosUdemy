package com.raul.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raul.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "pepe", "gonzalez"));
        users.add(new User(1L, "pepe", "gonzalez"));
        users.add(new User(1L, "pepe", "gonzalez"));
        users.add(new User(1L, "pepe", "gonzalez"));
        users.add(new User(1L, "pepe", "gonzalez"));
        users.add(new User(1L, "pepe", "gonzalez"));
        return users;
    }
}
