package com.raul.curso.springboot.app.springboot_crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.raul.curso.springboot.app.springboot_crud.security.filter.JwtAuthenticationfilter;


@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration autConf;

    @Bean
    AuthenticationManager authenticationManager() throws Exception{
            return autConf.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((a) -> a
        .requestMatchers(HttpMethod.GET, "/users").permitAll()
        .requestMatchers(HttpMethod.POST, "/users/register").permitAll()
        .anyRequest().authenticated())
        .addFilter(new JwtAuthenticationfilter(authenticationManager()))
        .csrf(config -> config.disable())
        .sessionManagement(m -> m.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }
}
