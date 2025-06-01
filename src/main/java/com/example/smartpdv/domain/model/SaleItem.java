package com.example.smartpdv.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")  // nome da coluna FK na tabela sale_item
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id") // nome da coluna FK na tabela sale_item
    private Product product;

    private int quantity;

    private BigDecimal uniquePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUniquePrice() {
        return uniquePrice;
    }

    public void setUniquePrice(BigDecimal uniquePrice) {
        this.uniquePrice = uniquePrice;
    }
}
