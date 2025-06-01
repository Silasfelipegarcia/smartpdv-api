package com.example.smartpdv.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateTime;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "client_id") // FK para Client
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id") // FK para User
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }
}
