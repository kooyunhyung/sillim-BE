package com.example.sillim.service.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeCommentElasticSearch;
import com.example.sillim.entity.elasticsearch.NoticeElasticSearch;
import com.example.sillim.repository.elasticsearch.NoticeCommentElasticSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeCommentElasticSearchService {

    @Autowired
    private NoticeCommentElasticSearchRepo noticeCommentElasticSearchRepo;

    public NoticeCommentElasticSearch insertNoticeComments(NoticeCommentElasticSearch noticeComment){
        return noticeCommentElasticSearchRepo.save(noticeComment);
    }

    public Iterable<NoticeCommentElasticSearch> getNoticeComments() {
        return noticeCommentElasticSearchRepo.findAll();
    }

    public void deleteNoticeComments(int id ){
        noticeCommentElasticSearchRepo.deleteById(id);
    }
}
