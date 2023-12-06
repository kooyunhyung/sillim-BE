package com.example.sillim.repository;

import com.example.sillim.entity.Board;
import com.example.sillim.entity.BoardElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BoardElasticSearchRepo extends ElasticsearchRepository<BoardElasticSearch, Integer> {
}
