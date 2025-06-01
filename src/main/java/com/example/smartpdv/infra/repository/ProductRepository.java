package com.example.smartpdv.infra.repository;

import com.example.smartpdv.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
