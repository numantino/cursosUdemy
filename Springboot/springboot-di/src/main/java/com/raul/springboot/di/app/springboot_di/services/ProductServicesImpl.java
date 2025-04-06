package com.raul.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.raul.springboot.di.app.springboot_di.models.Product;
import com.raul.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private Environment environment;
    @Autowired
    //@Qualifier("productList")
    private ProductRepository repository;

    //public ProductServicesImpl(@Qualifier("productList") ProductRepository repository){
    //    this.repository = repository;
    //}

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            // Creamos otro pructo nuevo con los datos modificados para no modificar el producto original
            // return new Product(p.getId(), p.getName(), priceImp.longValue());
            
            // Con clonables
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
            //p.setPrice((priceImp.longValue()));
            //return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
