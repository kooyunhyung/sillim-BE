package com.example.sillim.controller.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardCommentElasticSearch;
import com.example.sillim.service.elasticsearch.BoardCommentElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis2/comment")
public class BoardCommentElasticSearchController {

    @Autowired
    private BoardCommentElasticSearchService boardCommentElasticSearchService;

    @GetMapping("/findAll")
    Iterable<BoardCommentElasticSearch> findAll() {
        return boardCommentElasticSearchService.getBoardComments();
    }

    @PostMapping("/insert")
    BoardCommentElasticSearch insertBoardComment(@RequestBody BoardCommentElasticSearch boardComment) {
        return boardCommentElasticSearchService.insertBoardComments(boardComment);
    }

    @DeleteMapping("/delete/{id}")
    void deleteBoardComment(@PathVariable int id) {
        boardCommentElasticSearchService.deleteBoardComments(id);
    }

    // delete by cascading
//    @DeleteMapping("/deleteByCascading/{board_id}")
//    void deleteBoardCommentByCascading(@PathVariable int board_id) {
//        boardCommentElasticSearchService.deleteBoardCommentsByCascading(board_id);
//    }
}
