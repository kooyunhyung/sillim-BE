package com.example.sillim.controller.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardElasticSearch;
import com.example.sillim.service.elasticsearch.BoardElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis2")
public class BoardElasticSearchController {

    @Autowired
    private BoardElasticSearchService boardElasticSearchService;

    @GetMapping("/findAll")
    Iterable<BoardElasticSearch> findAll() {
        return boardElasticSearchService.getBoards();
    }

    @PostMapping("/insert")
    BoardElasticSearch insertBoard(@RequestBody BoardElasticSearch board) {
        return boardElasticSearchService.insertBoards(board);
    }

    @DeleteMapping("/delete/{id}")
    void deleteBoard(@PathVariable int id) {
        boardElasticSearchService.deleteBoards(id);
    }
}
