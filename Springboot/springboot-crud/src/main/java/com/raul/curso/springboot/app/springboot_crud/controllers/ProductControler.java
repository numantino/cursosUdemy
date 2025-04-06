package com.raul.curso.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.app.springboot_crud.entities.Product;
import com.raul.curso.springboot.app.springboot_crud.services.ProdcutService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/products")
public class ProductControler {
    @Autowired
    private ProdcutService service;

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Product> prod = service.findById(id);

        if (prod.isPresent()){
            return ResponseEntity.ok(prod.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product prod, BindingResult result){

        if (result.hasFieldErrors()){
            return validation(result);
        }

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(service.save(prod));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product prod, BindingResult result, @PathVariable Long id){
        if (result.hasFieldErrors()){
            return validation(result);
        }

        Optional<Product> prodOp = service.update(id, prod);
        if (prodOp.isPresent())
        {
            return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(prodOp.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> prodOp = service.delete(id);
        if (prodOp.isPresent()){
            return ResponseEntity.ok(prodOp.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
       Map<String, String> errors = new HashMap<>(); 
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

       return ResponseEntity.badRequest().body(errors);
    }
}
