package com.raul.curso.springboot.webapp.springbootweb.controllers.models;

public class User {

    private String name;
    private String lastname;
    private String email;

    public User() {
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    public User(String name, String lastname, String email) {
        this(name, lastname);
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
