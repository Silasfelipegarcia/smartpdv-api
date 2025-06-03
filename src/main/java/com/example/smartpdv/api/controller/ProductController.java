package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.ProductRequest;
import com.example.smartpdv.domain.model.Product;
import com.example.smartpdv.domain.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {


    @Autowired
    private IProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity registerProduct(@RequestBody ProductRequest productRequest){
        productService.registerProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
