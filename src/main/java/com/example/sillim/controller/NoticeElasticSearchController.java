package com.example.sillim.controller;

import com.example.sillim.entity.NoticeElasticSearch;
import com.example.sillim.service.NoticeElasticSearchService;
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
}
