package com.raul.curso.springboot.app.springboot_crud.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raul.curso.springboot.app.springboot_crud.entities.User;
import com.raul.curso.springboot.app.springboot_crud.repositories.UserRepository;

@Service
public class JPAUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opUser = repository.findByUserName(username);

        if(opUser.isEmpty()){
            throw new UsernameNotFoundException(String.format("username %s no existe en el sistema!!", username));
        }

        User user = opUser.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());  

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), 
            user.getPassword(), 
            user.isEnabled(),
            true,
            true,
            true,
            authorities
            );
    }

}
