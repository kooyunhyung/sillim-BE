package com.example.sillim.repository.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardCommentElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardCommentElasticSearchRepo extends ElasticsearchRepository<BoardCommentElasticSearch,Integer> {

}
