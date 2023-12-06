package com.example.sillim.repository;

import com.example.sillim.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {

}
