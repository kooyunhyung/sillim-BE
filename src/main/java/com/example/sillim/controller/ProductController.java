package com.example.sillim.controller;

import com.example.sillim.entity.Product;
import com.example.sillim.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    Iterable<Product> findAll() {
        return productService.getProducts();
    }

    @PostMapping("/insert")
    Product insertProduct(@RequestBody Product product) {
        return productService.insertProducts(product);
    }
}
