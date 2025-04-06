package com.raul.springboot.di.app.springboot_di.services;

import java.util.List;

import com.raul.springboot.di.app.springboot_di.models.Product;

public interface ProductServices {
    List<Product> findAll();
    Product findById(Long id);
}
