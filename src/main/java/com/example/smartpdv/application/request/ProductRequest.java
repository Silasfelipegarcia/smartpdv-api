package com.example.smartpdv.application.request;

import com.example.smartpdv.domain.model.Product;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ProductRequest {

    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product converter() {
        Product product = new Product();
        product.setName(this.name);
        product.setPrice(this.price);
        product.setBarcode("asdhuasdhua");
        return product;
    }
}
