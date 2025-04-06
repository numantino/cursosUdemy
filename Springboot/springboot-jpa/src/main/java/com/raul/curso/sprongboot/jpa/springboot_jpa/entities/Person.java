package com.raul.curso.sprongboot.jpa.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;    
    private String lastname;    
    @Column(name = "programming_language")
    private String programmingLanguage;

    @Embedded
    private Audit audit;

    // Si ponemos constructores, es necesario un constructor vacio para el manejo de JPA
    public Person() {
    }

    public Person(Long id, String name, String lastname, String programingLanguages) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programingLanguages;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programingLanguages) {
        this.programmingLanguage = programingLanguages;
    }


    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", lastname=" + lastname + ", programingLanguages="
                + programmingLanguage + "]";
    }

}
