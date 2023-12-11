package com.example.sillim.service.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeElasticSearch;
import com.example.sillim.repository.elasticsearch.NoticeElasticSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeElasticSearchService {

    @Autowired
    private NoticeElasticSearchRepo noticeElasticSearchRepo;

    public NoticeElasticSearch insertNotices(NoticeElasticSearch notice){
        return noticeElasticSearchRepo.save(notice);
    }

    public Iterable<NoticeElasticSearch> getNotices() {
        return noticeElasticSearchRepo.findAll();
    }

    public void deleteNotices(int id ){
        noticeElasticSearchRepo.deleteById(id);
    }
}
