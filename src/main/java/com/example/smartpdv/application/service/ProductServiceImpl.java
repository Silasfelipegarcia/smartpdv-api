package com.example.smartpdv.application.service;

import com.example.smartpdv.application.request.ProductRequest;
import com.example.smartpdv.application.response.ProductResponse;
import com.example.smartpdv.domain.model.Product;
import com.example.smartpdv.domain.service.IProductService;
import com.example.smartpdv.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> registerProduct(ProductRequest productRequest) {
        productRepository.save(productRequest.converter());


        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
