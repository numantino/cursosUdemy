package com.raul.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.di.factura.springboot_difactura.models.Client;
import com.raul.curso.springboot.di.factura.springboot_difactura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/invoices")
public class InvoiceControler {

    @Autowired
    private Invoice invoice;
    
    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice();
        Client c = new Client();
        c.setName(invoice.getCliente().getName());
        c.setLastName(invoice.getCliente().getLastName());
        i.setCliente(c);
        i.setDescripcion(invoice.getDescripcion());
        i.setItems(invoice.getItems());
        return i;
    }
}
