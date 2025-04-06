package com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
 
} 
