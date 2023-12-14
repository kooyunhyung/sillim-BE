package com.example.sillim.controller.elasticsearch;

import com.example.sillim.entity.elasticsearch.NoticeCommentElasticSearch;
import com.example.sillim.service.elasticsearch.NoticeCommentElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis3/comment")
public class NoticeCommentElasticSearchController {

    @Autowired
    private NoticeCommentElasticSearchService noticeCommentElasticSearchService;

    @GetMapping("/findAll")
    Iterable<NoticeCommentElasticSearch> findAll() {
        return noticeCommentElasticSearchService.getNoticeComments();
    }

    @PostMapping("/insert")
    NoticeCommentElasticSearch insertNoticeComment(@RequestBody NoticeCommentElasticSearch noticeComment) {
        return noticeCommentElasticSearchService.insertNoticeComments(noticeComment);
    }

    @DeleteMapping("/delete/{id}")
    void deleteNoticeComment(@PathVariable int id) {
        noticeCommentElasticSearchService.deleteNoticeComments(id);
    }
}
