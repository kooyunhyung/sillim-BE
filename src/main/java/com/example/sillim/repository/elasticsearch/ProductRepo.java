package com.example.sillim.repository.elasticsearch;

import com.example.sillim.entity.elasticsearch.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {

}
