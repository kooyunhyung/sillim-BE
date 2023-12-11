package com.example.sillim.controller.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeElasticSearch;
import com.example.sillim.service.elasticsearch.NoticeElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis3")
public class NoticeElasticSearchController {

    @Autowired
    private NoticeElasticSearchService noticeElasticSearchService;

    @GetMapping("/findAll")
    Iterable<NoticeElasticSearch> findAll() {
        return noticeElasticSearchService.getNotices();
    }

    @PostMapping("/insert")
    NoticeElasticSearch insertNotice(@RequestBody NoticeElasticSearch notice) {
        return noticeElasticSearchService.insertNotices(notice);
    }

    @DeleteMapping("/delete/{id}")
    void deleteNotice(@PathVariable int id) {
        noticeElasticSearchService.deleteNotices(id);
    }
}
