package com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

} 