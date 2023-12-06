package com.example.sillim.service;

import com.example.sillim.entity.Product;
import com.example.sillim.repository.ProductRepo;
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

    public Product updateProducts(Product product, int id) {
        Product product1= productRepo.findById(id).get();
        product1.setPrice(product.getPrice());
        return product1;
    }

    public void deleteProducts(int id) {
        productRepo.deleteById(id);
    }
}
