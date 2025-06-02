package com.example.smartpdv.api.controller;


import com.example.smartpdv.application.request.ProductRequest;
import com.example.smartpdv.application.response.ProductResponse;
import com.example.smartpdv.domain.model.Product;
import com.example.smartpdv.domain.service.IProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProdutoController {


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
