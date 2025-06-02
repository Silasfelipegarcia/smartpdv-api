package com.example.smartpdv.domain.service;

import com.example.smartpdv.application.request.ProductRequest;
import com.example.smartpdv.application.response.ProductResponse;
import com.example.smartpdv.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> registerProduct(ProductRequest productRequest);

    List<Product> findAll();

}
