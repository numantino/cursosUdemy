package com.raul.curso.springboot.di.factura.springboot_difactura.models;

public class Item {

    private Product prodcut;

    private Integer quality;


    public Item() {
    }
    public Item(Product prodcut, Integer quality) {
        this.prodcut = prodcut;
        this.quality = quality;
    }
    public Product getProdcut() {
        return prodcut;
    }
    public void setProdcut(Product prodcut) {
        this.prodcut = prodcut;
    }
    public Integer getQuality() {
        return quality;
    }
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public int getImporte(){
        return quality * prodcut.getPrice();
    }
}
