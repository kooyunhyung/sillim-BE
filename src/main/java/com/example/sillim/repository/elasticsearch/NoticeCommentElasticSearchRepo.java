package com.example.sillim.repository.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeCommentElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NoticeCommentElasticSearchRepo extends ElasticsearchRepository<NoticeCommentElasticSearch, Integer> {
}
