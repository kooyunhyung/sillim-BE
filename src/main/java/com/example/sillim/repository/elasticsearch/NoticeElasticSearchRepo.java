package com.example.sillim.repository.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NoticeElasticSearchRepo extends ElasticsearchRepository<NoticeElasticSearch, Integer> {
}
