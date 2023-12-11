package com.example.sillim.repository.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BoardElasticSearchRepo extends ElasticsearchRepository<BoardElasticSearch, Integer> {
}
