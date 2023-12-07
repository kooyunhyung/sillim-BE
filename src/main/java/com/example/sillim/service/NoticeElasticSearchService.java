package com.example.sillim.service;

import com.example.sillim.entity.NoticeElasticSearch;
import com.example.sillim.repository.NoticeElasticSearchRepo;
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

    public NoticeElasticSearch updateNotices(NoticeElasticSearch notice, int id) {
        NoticeElasticSearch notice1= noticeElasticSearchRepo.findById(id).get();
        notice1.setNoticeContent(notice.getNoticeContent());
        return notice1;
    }

    public void deleteNotices(int id ){
        noticeElasticSearchRepo.deleteById(id);
    }
}
