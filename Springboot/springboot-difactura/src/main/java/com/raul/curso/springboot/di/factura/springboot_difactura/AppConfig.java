package com.raul.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.raul.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.raul.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){        
        return Arrays.asList(
            new Item(new Product("Camara", 100), 2), 
            new Item(new Product("Bicicleta", 250), 4));
    }

    @Bean("default")
    List<Item> itemsInvoiceOficina(){        
        return Arrays.asList(
            new Item(new Product("monitor", 100), 2), 
            new Item(new Product("teclado", 250), 4),
            new Item(new Product("raton", 10), 10));
    }
}
