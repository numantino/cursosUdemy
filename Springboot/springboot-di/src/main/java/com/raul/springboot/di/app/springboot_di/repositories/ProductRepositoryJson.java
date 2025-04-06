package com.raul.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raul.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    List<Product> list;

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource){
        readValueJson(resource);
    }

    private void readValueJson(Resource resource){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
       return list.stream().filter((p ->  p.getId().equals(id))).findFirst().orElseThrow();
    }

}
