package com.example.smartpdv.application.response;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ProductResponse {

    private String name;

    private String barcode;

    private BigDecimal price;

    private int quantityStock;

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }
}
