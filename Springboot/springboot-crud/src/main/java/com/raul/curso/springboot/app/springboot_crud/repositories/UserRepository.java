package com.raul.curso.springboot.app.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.raul.curso.springboot.app.springboot_crud.entities.User;


public interface UserRepository extends CrudRepository<User, Long>{
    boolean existexistsByUserName(String username);
    Optional<User> findByUserName(String username);
;} 
