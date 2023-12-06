package com.example.sillim.repository;

import com.example.sillim.entity.NoticeElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NoticeElasticSearchRepo extends ElasticsearchRepository<NoticeElasticSearch, Integer> {
}
