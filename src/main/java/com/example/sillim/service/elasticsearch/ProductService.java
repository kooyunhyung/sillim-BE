package com.example.sillim.service.elasticsearch;

import com.example.sillim.entity.elasticsearch.Product;
import com.example.sillim.repository.elasticsearch.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product insertProducts(Product product) {
        return productRepo.save(product);
    }

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    public void deleteProducts(int id) {
        productRepo.deleteById(id);
    }
}
