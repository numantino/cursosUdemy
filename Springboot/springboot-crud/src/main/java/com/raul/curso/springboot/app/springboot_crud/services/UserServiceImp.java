package com.raul.curso.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raul.curso.springboot.app.springboot_crud.entities.Role;
import com.raul.curso.springboot.app.springboot_crud.entities.User;
import com.raul.curso.springboot.app.springboot_crud.repositories.RoleRepository;
import com.raul.curso.springboot.app.springboot_crud.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optRolUser = rolRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        optRolUser.ifPresent(roles::add);

        if (user.isAdmin()){
            Optional<Role> optRolAdmin = rolRepository.findByName("ROLE_ADMIN");
            optRolAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    @Override
    public boolean existexistsByUserName(String username) {
       return repository.existexistsByUserName(username);
    }

}
